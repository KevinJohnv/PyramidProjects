package Board;

import Ship.BattleShip;
import Ship.Carrier;
import Ship.PatrolBoat;
import Ship.Submarine;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private String board[][] = new String[10][10];

    //Creates a empty board
    public Board(){
        //Fills the board with ~ to represent water

        for(int row = 0;row<board[0].length;row++){
            for(int column = 0; column<board.length; column++){
                board[row][column] = "  ~  ";
            }
        }

        //Border set up
        board[0][0] = " ";
        for(int row=1; row<board.length;row++){
            board[row][0] = (""+row);
        }

        for(int column=1; column<board.length;column++){
            board[0][column] = ("  "+column+"  ");
        }
    }

    //If true is passed it will auto generate a board, if false it will request coordinated to place the boats
    public Board(boolean auto){
        //Fills the board with ~ to represent water

        for(int row = 0;row<board[0].length;row++){
            for(int column = 0; column<board.length; column++){
                board[row][column] = "  ~  ";
            }
        }

        //Border set up
        board[0][0] = " ";
        for(int row=1; row<board.length;row++){
            board[row][0] = (""+row);
        }

        for(int column=1; column<board.length;column++){
            board[0][column] = ("  "+column+"  ");
        }

        //Board ship placement
        if(auto){
            //If true randomly place the boats
            Carrier carrier = new Carrier();
            spawn(carrier.getLength(), carrier.getId());

            BattleShip battleShip = new BattleShip();
            spawn(battleShip.getLength(), battleShip.getId());

            Submarine submarine = new Submarine();
            spawn(submarine.getLength(), submarine.getId());

            PatrolBoat patrolBoat = new PatrolBoat();
            spawn(patrolBoat.getLength(), patrolBoat.getId());


        }else{
            //Manually place the boats
            Carrier carrier = new Carrier();
            System.out.println("Boat being placed Carrier length"+ carrier.getLength());
            maunalSpawn(carrier.getLength(),carrier.getId());
            System.out.println(toString());

            BattleShip battleShip = new BattleShip();
            System.out.println("Boat being placed BattleShip length"+ battleShip.getLength());
            maunalSpawn(battleShip.getLength(),battleShip.getId());
            System.out.println(toString());

            Submarine submarine = new Submarine();
            System.out.println("Boat being placed Submarine length"+ submarine.getLength());
            maunalSpawn(submarine.getLength(),submarine.getId());
            System.out.println(toString());

            PatrolBoat patrolBoat = new PatrolBoat();
            System.out.println("Boat being placed Patrol Boat length"+ patrolBoat.getLength());
            maunalSpawn(patrolBoat.getLength(),patrolBoat.getId());
            System.out.println(toString());

        }

    }

    public void maunalSpawn(int length, String id){
        boolean spawned = false;
        Scanner scanner = new Scanner(System.in);

        while(!spawned){
            System.out.println("Enter the coords you want the boat to start(the boat will extend in the positive direction)");
            System.out.print("Row: ");
            int row = scanner.nextInt();

            System.out.print("\nColumn:");
            int column = scanner.nextInt();

            System.out.print("\nDirection(v/h)");
            String direction = scanner.next();

            spawned=true;


            if(direction.equalsIgnoreCase("v")){
                if(row+length > board.length-1){
                    spawned = false;
                }else{

                }
            }else if(column+length > board.length-1){
                spawned = false;
            }

            //Spawns on map
            if(spawned){

                //Checks if area already has something spawned in
                if(direction.equalsIgnoreCase("v")){
                    for(int i = row; i<row+length; i++){
                        if(!board[i][column].contains("~")){
                            spawned = false;
                        }
                    }
                }else{
                    for(int i = column; i<column+length; i++){
                        if(!board[row][i].contains("~")){
                            spawned = false;
                        }
                    }
                }

                if(spawned){
                    //Checks orientation
                    if(direction.equalsIgnoreCase("v")){
                        for(int i = row; i<row+length; i++){
                            board[i][column]= ("  "+id+"  ");
                        }
                    }else{
                        for(int i = column; i<column+length; i++){
                            board[row][i]= ("  "+id+"  ");
                        }
                    }
                }

            }else{
                System.out.println("Invalid placement");
            }
        }


    }

    //Randomly spawns ships given a length
    private void spawn(int length, String id){
        boolean spawned = false;

        while(!spawned){
            Random random = new Random();
            int row = (int)Math.floor(Math.random()*(9-1+1)+1);
            int column = (int)Math.floor(Math.random()*(9-1+1)+1);
            String direction = "";

            int randDirection = random.nextInt(2);
            if(0== randDirection){
                direction = "h";
            }else{
                direction = "v";
            }

            //Checks to see if the ship can fit on the board
            spawned = true;
            if(direction.equalsIgnoreCase("v")){
                if(row+length > board.length-1){
                    spawned = false;
                }
            }else{
                if(column+length > board.length-1){
                    spawned = false;
                }
            }

            //Spawns on map
            if(spawned){

                //Checks if area already has something spawned in
                if(direction.equalsIgnoreCase("v")){
                    for(int i = row; i<row+length; i++){
                        if(!board[i][column].contains("~")){
                            spawned = false;
                        }
                    }
                }else{
                    for(int i = column; i<column+length; i++){
                        if(!board[row][i].contains("~")){
                            spawned = false;
                        }
                    }
                }

                if(spawned){
                    //Checks orientation
                    if(direction.equalsIgnoreCase("v")){
                        for(int i = row; i<row+length; i++){
                            board[i][column]= ("  "+id+"  ");
                        }
                    }else{
                        for(int i = column; i<column+length; i++){
                            board[row][i]= ("  "+id+"  ");
                        }
                    }
                }

            }
        }

    }

    //Returns a String that will display the board
    public String toString(){
        String message = "";

        for(int row = 0; row < board[0].length; row++){
            for(int column = 0; column< board[0].length;column++){
                message = message+board[row][column];
            }
            message = message+"\n";
        }
        return message;
    }

    public String[][] getBoard(){
        return board;
    }

    //Given coordinates it will attack at the coords. Returns 0 if invalid move 1 if hit 2 if miss
    public int attack(int row, int column){
        int hit = 0;

        //Checks if the row and column are within the board and has not been fired at before
        if(row<board.length && (row > 0)&& (column<board.length)&&(column>0) && !board[row][column].contains("X")){

            //Checks to see if it is a hit
            if(!board[row][column].contains("~") ){
                System.out.println("Hit");
                board[row][column] = "  X  ";
                hit = 1;
            }else{
                System.out.println("Miss!");
                hit = 2;
                board[row][column] = "  O  ";
            }
        }else{

        }

        return hit;
    }

    public void editBoard(int row, int column, String s){
        board[row][column] = s;
    }

    //Returns true if game is lost. False if game is not over
    public boolean lose(){
        boolean gameLost = true;
        for(int row = 0;row<board[0].length;row++){
            for(int column = 0; column<board.length; column++){
                //Checks to see if there are any letter (C,S,B,P) on the board signifiying that there is a ship still alive
                //If so then then gameLost = false
                if(
                        board[row][column].contains("S") ||
                        board[row][column].contains("C") ||
                        board[row][column].contains("P") ||
                        board[row][column].contains("B")
                ){
                    gameLost = false;
                }
            }
        }

        return gameLost;
    }

}
