import Board.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Step 1 Build boards
        Board compBoard = new Board(true);
        Board invisBoard = new Board();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String player1 = scanner.next();

        System.out.println("Enter the computers name");
        String player2 = scanner.next();

        System.out.println("Build your board");
        Board playerBoard = new Board(true);

        //GameLoop
        // 0 = comp turn 1= player turn
        int turn = 0;
        boolean gameover = false;

        while(!gameover){
            if(turn == 0){
                //Computer turn
                int attack =0;
                while(attack == 0){
                    int row = (int)Math.floor(Math.random()*(9-1+1)+1);
                    int column = (int)Math.floor(Math.random()*(9-1+1)+1);

                    attack = playerBoard.attack(row,column);

                    if(attack == 1){
                        playerBoard.editBoard(row,column,"  X  ");
                        System.out.println("Hit! "+player2+" enter the coordinates for and attack: ("+row+","+column+")");

                    }else{
                        playerBoard.editBoard(row,column,("  O  "));
                        System.out.println("Miss... "+player2+" enter the coordinates for and attack: ("+row+","+column+")");
                    }
                }

                turn = 1;

            }else{
                //Player turn
                int attack = 0;
                int row = 0;
                int column = 0;
                while(attack == 0){

                    System.out.print("Enter valid coordinates.\nThe one you selected is either out side of the map or has already been shot at\nRow: ");
                    row = scanner.nextInt();

                    System.out.print("\nColumn: ");
                    column = scanner.nextInt();

                    attack = compBoard.attack(row,column);
                }

                if(attack == 1){
                    invisBoard.editBoard(row,column,"  X  ");
                    System.out.println("Hit "+player1+" enter the coordinates for and attack: ("+row+","+column+")");
                }else{
                    invisBoard.editBoard(row,column,("  O  "));
                    System.out.println("Miss... "+player1+" enter the coordinates for and attack: ("+row+","+column+")");
                }

                turn=0;

            }

            System.out.println(invisBoard.toString()+"\n"+playerBoard.toString());

            if(compBoard.lose()||playerBoard.lose()){
                gameover=true;
            }
        }

        if(compBoard.lose()){
            System.out.println("YOU WON!");
        }else{
            System.out.println("YOU LOST....");
        }





    }
}
