import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Land {
    int size = 5;
    String[][] land = new String[size][size];
    public Land(){
        for (String[] row: land)
            Arrays.fill(row, " ");
    }



    //Returns:
    //0 - Out of bounds
    //1 - Space is occupied
    //2 - Space is empty
    //3 - None directional entered
    public int peek(Creature creature, String direction){
        int row = creature.getRow();
        int column = creature.getColumn();
        if(direction.equalsIgnoreCase("n")){
            if(row-1 < 0 ){
                return 0;
            }else if(land[row-1][column].equalsIgnoreCase(" ")){
                return 2;
            }else{
                return 1;
            }
        }else if (direction.equalsIgnoreCase("s")){
            if(row+1>=land.length){
                return 0;
            }else if(land[row+1][column].equalsIgnoreCase(" ")){
                return 2;
            }else{
                return 1;
            }

        }else if (direction.equalsIgnoreCase("e")){
            if(column+1>=land[0].length){
                return 0;
            }else if(land[row][column+1].equalsIgnoreCase(" ")){
                return 2;
            }else{
                return 1;
            }
        }else if (direction.equalsIgnoreCase("w")){
            if(column-1<0){
                return 0;
            }else if(land[row][column-1].equalsIgnoreCase(" ")){
                return 2;
            }else{
                return 1;
            }
        }else {return 3;}
    }

    public int peek(int row, int column){
        if(row>=land.length||row<0||column>=land[0].length||column<0){
            return 0;
        }else if(land[row][column].equalsIgnoreCase(" ")){
            return 2;
        }else{
            return 1;
        }
    }

    //Moves creature in a specified direction
    public void move(Creature creature, String direction){
        land[creature.getRow()][creature.getColumn()]= " ";

        if(direction.equalsIgnoreCase("n")){
            creature.setRow(creature.row-1);
        }else if (direction.equalsIgnoreCase("s")){
            creature.setRow(creature.row+1);
        }else if (direction.equalsIgnoreCase("e")){
            creature.setColumn(creature.getColumn()+1);
        }else if (direction.equalsIgnoreCase("w")){
            creature.setColumn(creature.getColumn()-1);
        }

        if(creature.getClass() == (new Human().getClass())){
            land[creature.getRow()][creature.getColumn()] = "H";
        }else{land[creature.getRow()][creature.getColumn()] = "G";}
    }

    //Returns the map as a string
    public String toString(){
        String message = "";
        message= message+ ("\n----------------------------------------------------\n");
        for (int i = 0; i < land.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < land[i].length; j++){
                message= message+ (land[i][j] + " ");
            }
            message= message+ ("\n");
        }
        message= message + ("----------------------------------------------------\n");
        return message;
    }

    //Places a creature randomly on the map
    public void spawn(Creature creature){
        Random random = new Random();
        int row = random.nextInt(land.length);
        int column = random.nextInt(land.length);

        while(peek(row,column) != 2){
            row = random.nextInt(land.length);
            column = random.nextInt(land.length);
        }

        creature.setRow(row);
        creature.setColumn(column);

        if(creature.getClass() == (new Human().getClass())){
            land[row][column] = "H";
        }else{land[row][column] = "G";}
    }

    /*    int[][] land = new int[3][3];

    public Land(){
        for (int[] row: land)
            Arrays.fill(row, 0);
    }

    public void spawn(int x, int y, Creature creature){
        if(creature.getClass() == (new Human()).getClass()){
            land[x][y] = 1;
        }else{
            land[x][y] = 2;
        }
    }

    //Takes in current location and direction and moves the piece if it can
    public ArrayList move(int x, int y, Creature creature, String direction){
        if(direction.equalsIgnoreCase("")){

        }
        coverTracks(x,y);
        if(creature.getClass() == (new Human()).getClass()){
            //If human then change the location to human
            return moveDirection(x,y,direction,1, creature);

        }else{
            return moveDirection(x,y,direction,2, creature);
        }
    }

    //Input: N/S/E/W
    //Output: Void
    //Description: Erases the tracks of a creature moving about.(Resests land back to 0)
    private void coverTracks(int x, int y){
        land[x][y] = 0;
    }

    //Input: Current Coords, Direction, and input char
    //Output: void
    //Description: Changes the directed tile to the given int
    private ArrayList moveDirection(int x, int y, String direction,int rep, Creature creature){
        if(direction.equalsIgnoreCase("n")){
            //peek(x,y+1);
            land[--x][y] = rep;
            creature.setPositionX(x-1);
        }else if(direction.equalsIgnoreCase("s")){
            land[++x][y] = rep;
            creature.setPositionX(x+1);
        }else if (direction.equalsIgnoreCase("e")){
            land[x][++y] = rep;
            creature.setPositionX(y+1);
        }else if(direction.equalsIgnoreCase("w")){
            land[x][--y] = rep;
            creature.setPositionX(y-1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(x);
        arr.add(y);
        return arr;
    }


    //Input: Coordinates X & Y
    //Output: TRUE if there is a object at the specified location. FALSE  if there is nothing at the location
    public int peek(int x, int y){
        //if selected area is out of bounds
        if(x > land.length || x<0 ||y>land[0].length||y<0){
            return 2;
        }else if(land[x][y] != 0){
            return 1;
        }else{
            return 0;
        }
    }

    public void print(){
        System.out.println("\n----------------------------------------------------");
        for (int i = 0; i < land.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < land[i].length; j++){
                System.out.print(land[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------\n");
    }


*/
}
