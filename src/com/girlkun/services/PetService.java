package com.girlkun.services;

import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.player.NewPet;
import com.girlkun.models.player.Pet;
import com.girlkun.models.player.Player;
import com.girlkun.models.player.Thu_TrieuHoi;
import com.girlkun.services.func.ChangeMapService;
import com.girlkun.utils.SkillUtil;
import com.girlkun.utils.Util;

public class PetService {

    private static PetService i;

    public static PetService gI() {
        if (i == null) {
            i = new PetService();
        }
        return i;
    }

    public void createNormalPet(Player player, int gender, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false, false,false, (byte) gender);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Xin hãy thu nhận làm đệ tử");
            } catch (Exception e) {
            }
        }).start();
    }

    public void createNormalPet(Player player, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false, false,false);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Xin hãy thu nhận làm đệ tử");
            } catch (Exception e) {
            }
        }).start();
    }

    public void createMabuPet(Player player, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, true, false,false);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Oa oa oa...");
            } catch (Exception e) {
            }
        }).start();
    }

    public void createMabuPet(Player player, int gender, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, true, false,false, (byte) gender);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Oa oa oa...");
            } catch (Exception e) {
            }
        }).start();
    }
    public void createBerusPet(Player player, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false, true,false);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Thần hủy diệt hiện thân tất cả quỳ xuống...");
            } catch (Exception e) {
            }
        }).start();
    }

    public void createBerusPet(Player player, int gender, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false, true,false, (byte) gender);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Thần hủy diệt hiện thân tất cả quỳ xuống...");
            } catch (Exception e) {
            }
        }).start();
    } public void createPicPet(Player player, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false, false,true);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Sư Phụ Broly hiện thân tụi mày quỳ xuống...");
            } catch (Exception e) {
            }
        }).start();
    }

    public void CreatePet(Player player, int gender, int type, byte... limitPower){
        new Thread(() -> {
            try {
                CreateNewPet(player, type, (byte) gender);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Sản phẩm lỗi tụi mày quỳ xuống...");
            } catch (Exception e) {
            }
        }).start();
    }

    public void createPicPet(Player player, int gender, byte... limitPower) {
        new Thread(() -> {
            try {
                createNewPet(player, false,false,true, (byte) gender);
                if (limitPower != null && limitPower.length == 1) {
                    player.pet.nPoint.limitPower = limitPower[0];
                }
                Thread.sleep(1000);
                Service.getInstance().chatJustForMe(player, player.pet, "Sư Phụ Broly hiện thân tụi mày quỳ xuống...");
            } catch (Exception e) {
            }
        }).start();
    }
    public void changeNormalPet(Player player, int gender) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createNormalPet(player, gender, limitPower);
    }

    public void changeNormalPet(Player player) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createNormalPet(player, limitPower);
    }

    public void changeMabuPet(Player player) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createMabuPet(player, limitPower);
    }

    public void changeMabuPet(Player player, int gender) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createMabuPet(player, gender, limitPower);
    }
    public void changeBerusPet(Player player) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createBerusPet(player, limitPower);
    }

    public void ChangePet(Player player, int gender, int type){
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        CreatePet(player, gender, type);
    }

    public void changeBerusPet(Player player, int gender) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createBerusPet(player, gender, limitPower);
    }
    public void changePicPet(Player player) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createPicPet(player, limitPower);
    }

    public void changePicPet(Player player, int gender) {
        byte limitPower = player.pet.nPoint.limitPower;
        if (player.fusion.typeFusion != ConstPlayer.NON_FUSION) {
            player.pet.unFusion();
        }
        ChangeMapService.gI().exitMap(player.pet);
        player.pet.dispose();
        player.pet = null;
        createPicPet(player, gender, limitPower);
    }
    public void changeNamePet(Player player, String name) {
        try {
            if (!InventoryServiceNew.gI().KtraItemBag(player, 400)) {
                Service.getInstance().sendThongBao(player, "Bạn cần thẻ đặt tên đệ tử, mua tại Santa");
                return;
            } else if (Util.haveSpecialCharacter(name)) {
                Service.getInstance().sendThongBao(player, "Tên không được chứa ký tự đặc biệt");
                return;
            } else if (name.length() > 10) {
                Service.getInstance().sendThongBao(player, "Tên quá dài");
                return;
            }
            ChangeMapService.gI().exitMap(player.pet);
            player.pet.name = "$" + name.toLowerCase().trim();
            InventoryServiceNew.gI().subQuantityItemsBag(player, InventoryServiceNew.gI().findItemBag(player, 400), 1);
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Service.getInstance().chatJustForMe(player, player.pet, "Cảm ơn sư phụ đã đặt cho con tên " + name);
                } catch (Exception e) {
                }
            }).start();
        } catch (Exception ex) {

        }
    }

    private int[] getDataPetNormal() {
        int[] hpmp = {1700, 1800, 1900, 2000, 2100, 2200};
        int[] petData = new int[5];
        petData[0] = Util.nextInt(40, 105) * 20; //hp
        petData[1] = Util.nextInt(40, 105) * 20; //mp
        petData[2] = Util.nextInt(20, 45); //dame
        petData[3] = Util.nextInt(9, 50); //def
        petData[4] = Util.nextInt(0, 2); //crit
        return petData;
    }

    private int[] getDataPetMabu() {
        int[] hpmp = {1700, 1800, 1900, 2000, 2100, 2200};
        int[] petData = new int[5];
        petData[0] = Util.nextInt(40, 105) * 20; //hp
        petData[1] = Util.nextInt(40, 105) * 20; //mp
        petData[2] = Util.nextInt(50, 120); //dame
        petData[3] = Util.nextInt(9, 50); //def
        petData[4] = Util.nextInt(0, 2); //crit
        return petData;
    }
    private int[] getDataPetBerus() {
        int[] hpmp = {1700, 1800, 1900, 2000, 2100, 2200};
        int[] petData = new int[5];
        petData[0] = Util.nextInt(40, 110) * 20; //hp
        petData[1] = Util.nextInt(40, 110) * 20; //mp
        petData[2] = Util.nextInt(50, 130); //dame
        petData[3] = Util.nextInt(9, 50); //def
        petData[4] = Util.nextInt(0, 2); //crit
        return petData;
    }

    private int[] getDataPetPicolo() {
        int[] hpmp = {1700, 1800, 1900, 2000, 2100, 2200};
        int[] petData = new int[5];
        petData[0] = Util.nextInt(40, 110) * 20; //hp
        petData[1] = Util.nextInt(40, 110) * 20; //mp
        petData[2] = Util.nextInt(50, 130); //dame
        petData[3] = Util.nextInt(9, 50); //def
        petData[4] = Util.nextInt(0, 2); //crit
        return petData;
    }
     private int[] getDataPetPic() {
        int[] hpmp = {2000, 2100, 2200, 2300, 2400,2500};
        int[] petData = new int[5];
        petData[0] = Util.nextInt(40, 125) * 20; //hp
        petData[1] = Util.nextInt(40, 125) * 20; //mp
        petData[2] = Util.nextInt(80, 160); //dame
        petData[3] = Util.nextInt(10, 60); //def
        petData[4] = Util.nextInt(2, 5); //crit
        return petData;
    }
     
    private void PropertiNewPet(Player player,String name, int type, byte... gender){
        int[] data = getDataPetPicolo();;
        Pet pet = new Pet(player);;

        pet.name = "$" + name;
        pet.gender = (gender != null && gender.length != 0) ? gender[0] : (byte) Util.nextInt(0, 2);
        pet.id = -player.id;
        pet.nPoint.power = 1500000;

        pet.typePet = (byte) type;

        pet.nPoint.stamina = 1000;
        pet.nPoint.maxStamina = 1000;
        pet.nPoint.hpg = data[0];
        pet.nPoint.mpg = data[1];
        pet.nPoint.dameg = data[2];
        pet.nPoint.defg = data[3];
        pet.nPoint.critg = data[4];
        for (int i = 0; i < 8; i++) {
            pet.inventory.itemsBody.add(ItemService.gI().createItemNull());
        }
        pet.playerSkill.skills.add(SkillUtil.createSkill(Util.nextInt(0, 2) * 2, 1));
        for (int i = 0; i < 3; i++) {
            pet.playerSkill.skills.add(SkillUtil.createEmptySkill());
        }
        pet.nPoint.setFullHpMp();
        player.pet = pet;
        data = null;
    }

    private void CreateNewPet(Player player,int type, byte... gender){
        switch (type){
            case 4: // picolo
                PropertiNewPet(player, "Picolo", type, gender);
                break;
            case 5:
                PropertiNewPet(player, "Anime", type, gender);
                break;
            case 6:
                PropertiNewPet(player, "Vegeta Hắc họa", type, gender);
                break;
            case 7:
                PropertiNewPet(player, "Gái xinh", type, gender);
                break;
            case 8:
                PropertiNewPet(player, "Vegeta Giáo sư", type, gender);
                break;
        }

    }

    private void createNewPet(Player player, boolean isMabu, boolean isBerus,boolean isPic, byte... gender) {
        int[] data = isMabu ? isPic ?  getDataPetMabu():getDataPetPic() : getDataPetNormal();
        Pet pet = new Pet(player);
        pet.name = "$" + (isMabu ? "Mabư" : isBerus ? "Berus" : isPic ? "Super Broly Huyền Thoại" : "Đệ tử");
        pet.gender = (gender != null && gender.length != 0) ? gender[0] : (byte) Util.nextInt(0, 2);
        pet.id = -player.id;
        pet.nPoint.power = isMabu || isBerus|| isPic ? 1500000 : 2000;
        pet.typePet = (byte) (isMabu ? 1 : isBerus ? 2 :isPic ? 3 : 0);
        pet.nPoint.stamina = 1000;
        pet.nPoint.maxStamina = 1000;
        pet.nPoint.hpg = data[0];
        pet.nPoint.mpg = data[1];
        pet.nPoint.dameg = data[2];
        pet.nPoint.defg = data[3];
        pet.nPoint.critg = data[4];
        for (int i = 0; i < 8; i++) {
            pet.inventory.itemsBody.add(ItemService.gI().createItemNull());
        }
        pet.playerSkill.skills.add(SkillUtil.createSkill(Util.nextInt(0, 2) * 2, 1));
        for (int i = 0; i < 3; i++) {
            pet.playerSkill.skills.add(SkillUtil.createEmptySkill());
        }
        pet.nPoint.setFullHpMp();
        player.pet = pet;
    }

    public static void Pet2(Player pl, int h, int b, int l) {
        if (pl.newpet != null ) {//&&pl.newpet1 != null
            pl.newpet.dispose();
//            pl.newpet1.dispose();
        }
        pl.newpet = new NewPet(pl, (short) h, (short) b, (short) l);
//        pl.newpet1 = new NewPet(pl, (short) h, (short) b, (short) l);
        pl.newpet.name = "$";
//        pl.newpet1.name = "$";
        pl.newpet.gender = pl.gender;
//          pl.newpet1.gender = pl.gender;
        pl.newpet.nPoint.tiemNang = 1;
//         pl.newpet1.nPoint.tiemNang = 1;
        pl.newpet.nPoint.power = 1;
//        pl.newpet1.nPoint.power = 1;
        pl.newpet.nPoint.limitPower = 1;
//         pl.newpet1.nPoint.limitPower = 1;
        pl.newpet.nPoint.hpg = 500;
//        pl.newpet1.nPoint.hpg = 500;
        pl.newpet.nPoint.mpg = 500;
//        pl.newpet1.nPoint.mpg = 500;
        pl.newpet.nPoint.hp = 500;
        pl.newpet.nPoint.mp = 500;
        pl.newpet.nPoint.dameg = 1;
        pl.newpet.nPoint.defg = 1;
        pl.newpet.nPoint.critg = 1;
        pl.newpet.nPoint.stamina = 1;
        pl.newpet.nPoint.setBasePoint();
        pl.newpet.nPoint.setFullHpMp();
//        pl.newpet1.nPoint.hp = 500000000;
//        pl.newpet1.nPoint.mp = 500000000;
//        pl.newpet1.nPoint.dameg = 1;
//        pl.newpet1.nPoint.defg = 1;
//        pl.newpet1.nPoint.critg = 1;
//        pl.newpet1.nPoint.stamina = 1;
//        pl.newpet1.nPoint.setBasePoint();
//        pl.newpet1.nPoint.setFullHpMp();
    }
    public static void Thu_TrieuHoi(Player pl) {
        if (pl.TrieuHoipet != null) {
            pl.TrieuHoipet.dispose();
        }
        pl.TrieuHoipet = new Thu_TrieuHoi(pl);
        pl.TrieuHoipet.name ="$" + "["+ pl.NameThanthu(pl.TrieuHoiCapBac) + "] "+ pl.TenThuTrieuHoi;
        pl.TrieuHoipet.gender = pl.gender;
        pl.TrieuHoipet.nPoint.tiemNang = 1;
        pl.TrieuHoipet.nPoint.power = 1;
        pl.TrieuHoipet.nPoint.limitPower = 1;
        pl.TrieuHoipet.nPoint.hpg = pl.TrieuHoiHP;
        pl.TrieuHoipet.nPoint.mpg = 500000000;
        pl.TrieuHoipet.nPoint.hp = pl.TrieuHoiHP;
        pl.TrieuHoipet.nPoint.mp = 500000000;
        pl.TrieuHoipet.nPoint.dameg = pl.TrieuHoiDame;
        pl.TrieuHoipet.nPoint.defg = 1;
        pl.TrieuHoipet.nPoint.critg = 1;
        pl.TrieuHoipet.nPoint.stamina = 10000;
        pl.TrieuHoipet.nPoint.maxStamina = 10000;
        pl.TrieuHoipet.playerSkill.skills.add(SkillUtil.createSkill(17, 7));
        pl.TrieuHoipet.nPoint.setBasePoint();
        pl.TrieuHoipet.nPoint.setFullHpMp();
    }
 
    //--------------------------------------------------------------------------
}
