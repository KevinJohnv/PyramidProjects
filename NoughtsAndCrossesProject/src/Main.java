import Board.*;
import WinCon.WinConditions;
import AI.MiniMax;

import java.util.Random;
import java.util.Scanner;

//Player is X Computer is O

public class Main {
    public static void main(String[] args) {
        Start();
    }

    public static void Start(){
        //Vars
        Board board = new Board();
        WinConditions w = new WinConditions();
        String turn = "Computer";
        Scanner s = new Scanner(System.in);

        //Game loop

        //Ask if the player wants to start first or computer should start first
        boolean firstPlayerChosen = false;
        String input;

        while(firstPlayerChosen == false){

            System.out.println("Do you want to start(Y/N)");
             input = s.next();
            if(input.equalsIgnoreCase("y")){
                turn = "Player";
                firstPlayerChosen = true;
            }else if(input.equalsIgnoreCase("n")){
                turn = "Computer";
                firstPlayerChosen = true;
            }else{
                System.out.println("Invalid input try again");
            }
        }

        System.out.println("This board has the following structure. \n" +
                "1 | 2 | 3\n" +
                "4 | 5 | 6\n" +
                "7 | 8 | 9");


        //Check if the board is in a win condition
        while(w.win(board)==null){
            boolean validMove = false;
            board.print();


            while(validMove == false) {
                //Check whose turn it is
                if (turn.equalsIgnoreCase("player")) {
                    System.out.println("Enter a number between 1-9 to put ur move down");
                    int move = s.nextInt();

                    //Check if the move is valid
                    if(board.isOpen(move)){
                        board.placeMove(turn,move);
                        validMove = true;
                        turn = "Computer";
                    }else{
                        System.out.println("That move is invalid try a different one");
                        board.print();
                    }

                } else {
                    //Computer turn
                    int bestScore = -2147483648;
                    int move = -10;
                    MiniMax m = new MiniMax();

                    for(int i=1;i<10;i++){
                        if(board.isOpen(i)){
                            board.placeMove(turn,i);
                            int score = MiniMax.calculate(board,0,"Player");
                            board.undoMove(i);

                            if(score>bestScore){
                                bestScore = score;
                                move = i;
                            }

                        }
                    }

                    board.placeMove(turn,move);
                    turn = "Player";
                    validMove = true;
                }
            }


        }

        //Send the win/lose message
        board.print();
        if(Integer.parseInt(w.win(board).toString())  == 1){
            System.out.println("Seems like you lost, well better luck next time I guess...");
        }else if(Integer.parseInt(w.win(board).toString())  == -1){
            System.out.println("Congrats you won!");
        }
    }
}

