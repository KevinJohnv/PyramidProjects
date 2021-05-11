import java.util.Random;

public class Creature {
    int row;
    int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String toString(){
        return ("Current position is "+row+" "+ column);
    }


    public void attack(Creature creature){}


    /*int att = 10;
    int def = 10;
    int dex = 10;
    int health = 100;
    private int positionX = 0;
    private int postitionY = 0;

    public Creature(){}

    public Creature(Land land){
        //Spawn the creature somewhere on the land
        Random random = new Random();
        positionX = random.nextInt(land.land.length);
        postitionY = random.nextInt(land.land.length);
        while(land.peek(positionX,postitionY)){
            positionX = random.nextInt(land.land.length);
            postitionY = random.nextInt(land.land.length);
        }
        land.spawn(positionX,postitionY,this);
    }

    public int getHealth(){
        return health;
    }

    public int getAtt(){return att;}

    public int getDef(){return def;}

    public int getDex(){return dex;}

    public int getPositionX(){
        return positionX;
    }

    public int getPostitionY() {
        return postitionY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int postitionY) {
        this.postitionY = postitionY;
    }

    public String toString(){
        return ("This creature has "+att+"att, "+def+" def, "+dex+" dex\nCurrently located at x:"+positionX+" and" +
                "y: "+postitionY);
    }

    public void move(Land land, String direction){
        land.move(positionX,postitionY,this,direction);
    }

    public void attack(Creature target){
        if(target.getDef()<att){
            System.out.println("The attack does nothing");
        }else{
            target.setHealth(target.health-(target.getDef()-att));

            System.out.println("The attack connects, target is left with "+target.getHealth()+" health.");
        }
    }*/
}
