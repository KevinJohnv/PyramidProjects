public class Human extends Creature{
    String armor;
    String weapon;

    int baseAtt = 10;
    int baseDef = 10;
    int baseDex = 10;

    public Human(){}

    public Human(Land land){
        super(land);
    }

    public void setArmor(String armor) {
        this.armor = armor;
        updateGear();
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
        updateGear();
    }

    public void updateGear(){
        if(armor!=null){
            if(armor.equalsIgnoreCase("Shabby Armor")){
                setDef(baseDef+10);
            }else if(armor.equalsIgnoreCase("Cloth Armor")){
                setDef(baseDef+15);
            }else if(armor.equalsIgnoreCase("Rusty Armor")){
                setDef(baseDef+16);
            }else if(armor.equalsIgnoreCase("Chainmail Armor")){
                setDef(baseDef+19);
            }else if(armor.equalsIgnoreCase("Shiny Armor")){
                setDef(baseDef+25);
            }else if(armor.equalsIgnoreCase("Tempered Iron Armor")){
                setDef(baseDef+36);
            }else if(armor.equalsIgnoreCase("Samurai Armor")){
                setDef(baseDef+36);
            }else if(armor.equalsIgnoreCase("Knight Armor")){
                setDef(baseDef+40);
            }else if(armor.equalsIgnoreCase("Paladin Armor")){
                setDef(baseDef+42);
            }else if(armor.equalsIgnoreCase("Kings Armor")){
                setDef(baseDef+43);
            }else if(armor.equalsIgnoreCase("Mountain Armor")){
                setDef(baseDef+44);
            }else if(armor.equalsIgnoreCase("God's Fleece")){
                setDef(baseDef+100);
            }
        }

        if(weapon!= null){
            if(weapon.equalsIgnoreCase("Twig")){
                setAtt(baseAtt+1);
            }else if(weapon.equalsIgnoreCase("Stick")){
                setAtt(baseAtt+2);
            }else if(weapon.equalsIgnoreCase("Sharp Stick")){
                setAtt(baseAtt+3);
            }else if(weapon.equalsIgnoreCase("Broken Sword")){
                setAtt(baseAtt+4);
            }else if(weapon.equalsIgnoreCase("Rusty Blade")){
                setAtt(baseAtt+5);
            }else if(weapon.equalsIgnoreCase("Old Sword")){
                setAtt(baseAtt+5);
            }else if(weapon.equalsIgnoreCase("Iron Sword")){
                setAtt(baseAtt+7);
            }else if(weapon.equalsIgnoreCase("Knight's Sword")){
                setAtt(baseAtt+15);
            }else if(weapon.equalsIgnoreCase("Paladins Sword")){
                setAtt(baseAtt+20);
            }else if(weapon.equalsIgnoreCase("Kings Spear")){
                setAtt(baseAtt+35);
            }else if(weapon.equalsIgnoreCase("God's Toothpick")){
                setAtt(baseAtt+175);
            }
        }


    }

    public String toString(){
        return ("This human has "+att+"att, "+def+" def, "+dex+" dex " +
                "\nLocation x: "+getPositionX()+" y:"+getPostitionY());
    }
}
