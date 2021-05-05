public class Creature {
    int att = 10;
    int def = 10;
    int dex = 10;
    int health = 100;
    private int positionX = 0;
    private int postitionY = 0;

    public int getAtt(){return att;}

    public int getDef(){return def;}

    public int getDex(){return dex;}

    public int getPositionx(){
        return positionX;
    }

    public int getPostitionY() {
        return postitionY;
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
}
