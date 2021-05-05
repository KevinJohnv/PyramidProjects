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
    public void move(int x, int y, Creature creature,String direction){
       //Checks if move is possible
        boolean movePossible = true;
        if(
                (direction.equalsIgnoreCase("n") && x>=land.length)||
                (direction.equalsIgnoreCase("s") && x==0)||
                (direction.equalsIgnoreCase("e") && y>=land[0].length)||
                (direction.equalsIgnoreCase("w") && y==0)

        ){
            movePossible = false;
            System.out.printf("You run face first into the world border and can see the imprint of your face on the wall\n" +
                    "The flat earthers were right all along...");
        }

        if(movePossible){
            //Checks if something is already in the specified area
            if(peek(x,y)){
                //Battle Logic
            }else{
                coverTracks(x,y);
                if(creature.getClass() == (new Human()).getClass()){
                    //If human then change the location to human
                    moveDirection(x,y,direction,1);
                }else{
                    moveDirection(x,y,direction,2);
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
    private void moveDirection(int x, int y, String direction,int rep){
        boolean battle = false;
        if(direction.equalsIgnoreCase("n")){
            peek(x,y+1);
            land[y+1][x] = rep;
        }else if(direction.equalsIgnoreCase("s")){
            land[y-1][x] = rep;
        }else if (direction.equalsIgnoreCase("e")){
            land[y][x+1] = rep;
        }else if(direction.equalsIgnoreCase("w")){
            land[y][x-1] = rep;
        }
    }


    //Input: Coordinates X & Y
    //Output: TRUE if there is a object at the specified location. FALSE  if there is nothing at the location
    private boolean peek(int x, int y){
        if(land[x][y]!=0){
            System.out.println("There is something there");
            return true;

        }else{return false;}
    }

    public void print(){
        for (int[] x : land)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }



}
