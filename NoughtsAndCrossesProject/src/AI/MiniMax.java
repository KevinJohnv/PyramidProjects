package AI;

import Board.Board;
import WinCon.WinConditions;

public class MiniMax {
    public static int calculate(Board board, int depth, String turn){
        WinConditions w = new WinConditions();
        int bestScore = -2147483648;
        int move = -10;

        if(w.win(board)!= null){
            return Integer.parseInt(w.win(board).toString());
        }

        //Max player(Optimal move for computer)
        if(turn.equalsIgnoreCase("Computer")){
            for(int i=1;i<10;i++){
                if(board.isOpen(i)){
                    board.placeMove(turn,i);
                    int score = calculate(board,depth+1,"Player");
                    board.undoMove(i);

                    if(score>bestScore){
                        bestScore = score;
                        move = i;
                    }

                }
            }
            return bestScore;
        }else{
            //This is so that the algorithim finds the best move that the opposing player can play and predicts it
            //Min player (Optimal move for the Player)
            bestScore = 100000;

            for(int i=1;i<10;i++){
                if(board.isOpen(i)){
                    board.placeMove(turn,i);
                    int score = calculate(board,depth+1,"Computer");
                    board.undoMove(i);

                    if(score<bestScore){
                        bestScore = score;
                        move = i;
                    }

                }
            }
            return bestScore;
        }
    }
}
