import java.util.ArrayList;
import java.util.Arrays;

public class Land {
    int[][] land = new int[3][3];

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
       //Checks if move is possible
        int xD = 0;
        int yD = 0;

        if(direction.equalsIgnoreCase("n")){
            xD=x-1;
            yD = y;
        }else if(direction.equalsIgnoreCase("s")){
            xD = x+1;
            yD=y;
        }else if(direction.equalsIgnoreCase("e") ){
            yD = y+1;
            xD=x;
        }else if(direction.equalsIgnoreCase("w")){
            yD = y-1;
            xD=x;
        }else{
            System.out.println("SOMETHING WENT WRONG IN LAND LINE 34ISH");
        }

        if(
                (direction.equalsIgnoreCase("n") && x<=0)||
                (direction.equalsIgnoreCase("s") && x>=land.length-1)||
                (direction.equalsIgnoreCase("e") && y>=land[0].length-1)||
                (direction.equalsIgnoreCase("w") && y<=0)

        ){
            System.out.printf("You run face first into the world border and can see the imprint of your face on the wall\n" +
                    "The flat earthers were right all along...");
            return null;
        }else{
            //Checks if something is already in the specified area
            if(peek(xD,yD)){
                //Battle Logic
                ArrayList<Integer> arrayList = new ArrayList();
                arrayList.add(x);
                arrayList.add(y);

                return arrayList;
            }else{
                coverTracks(x,y);
                if(creature.getClass() == (new Human()).getClass()){
                    //If human then change the location to human
                    return moveDirection(x,y,direction,1);

                }else{
                    return moveDirection(x,y,direction,2);
                }
            }
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
    private ArrayList moveDirection(int x, int y, String direction,int rep){
        if(direction.equalsIgnoreCase("n")){
            //peek(x,y+1);
            land[--x][y] = rep;
        }else if(direction.equalsIgnoreCase("s")){
            land[++x][y] = rep;
        }else if (direction.equalsIgnoreCase("e")){
            land[x][++y] = rep;
        }else if(direction.equalsIgnoreCase("w")){
            land[x][--y] = rep;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(x);
        arr.add(y);
        return arr;
    }


    //Input: Coordinates X & Y
    //Output: TRUE if there is a object at the specified location. FALSE  if there is nothing at the location
    public boolean peek(int x, int y){
        if(land[x][y]!=0){
            return true;

        }else{return false;}
    }

    public boolean playerPeek(int x, int y){
        if(land[x][y]!=0){
            System.out.println("There is something there");
            return true;

        }else{return false;}
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



}
