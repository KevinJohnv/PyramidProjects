package Ship;

abstract class Ship {
    private boolean sunk =false;
    private int length = 0;
    private String id = "s";

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public boolean getSunk(){
        return sunk;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

