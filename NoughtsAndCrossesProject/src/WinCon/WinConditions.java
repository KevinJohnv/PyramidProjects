package WinCon;

import Board.Board;

import java.util.ArrayList;

public class WinConditions {
    //Input: Board object
    //Output: Object (0 for draw, -1 for Player win, +1 for AI win, NULL for the board is not complete)
    public WinConditions(){}

    public Object win(Board board){
        // Horizontal Wins
        boolean win1 = (board.pos1.equals(board.pos2)) && (board.pos1.equals(board.pos3)) &&    // X|X|X
                !board.pos1.equalsIgnoreCase(" ");                                   //  | |
                                                                                                //  | |

                                                                                                //  | |
        boolean win2 = (board.pos4.equals(board.pos5)) && (board.pos4.equals(board.pos6))       // X|X|X
                && !board.pos4.equalsIgnoreCase(" ");                                //  | |

                                                                                                //  | |
        boolean win3 = (board.pos7.equals(board.pos8)) && (board.pos7.equals(board.pos9))       //  | |
        && !board.pos7.equalsIgnoreCase(" ");                                        // X|X|X


        // Vertical Wins
                                                                                                // X| |
        boolean win4 = (board.pos1.equals(board.pos4)) && (board.pos1.equals(board.pos7))       // X| |
        && !board.pos1.equalsIgnoreCase(" ");                                        // X| |


                                                                                                //  |X|
        boolean win5 = (board.pos2.equals(board.pos5)) && (board.pos2.equals(board.pos8))       //  |X|
        && !board.pos2.equalsIgnoreCase(" ");                                        //  |X|


                                                                                                //  | |X
        boolean win6 = (board.pos3.equals(board.pos6)) && (board.pos3.equals(board.pos9))       //  | |X
        && !board.pos3.equalsIgnoreCase(" ");                                        //  | |X


        //Diagonal Wins
                                                                                                // X| |
        boolean win7 = (board.pos1.equals(board.pos5)) && (board.pos1.equals(board.pos9))       //  |X|
        && !board.pos1.equalsIgnoreCase(" ");                                        //  | |X


                                                                                                //  | |X
        boolean win8 = (board.pos5.equals(board.pos3)) && (board.pos5.equals(board.pos7))       //  |X|
        && !board.pos5.equalsIgnoreCase(" ");                                        // X| |


        //Go through all the wins and see if any are true if so return the appropriate number (1 for win -1 for loss 0 for neither)
        if(win1){
            if(board.pos1.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win2){
            if(board.pos4.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win3){
            if(board.pos7.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win4){
            if(board.pos1.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win5){
            if(board.pos2.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win6){
            if(board.pos3.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win7){
            if(board.pos1.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(win8){
            if(board.pos5.equals("X") ){
                return -1;
            }else{return  1;}
        }else if(tabelIsFull(board)){return 0;}else{return  null;}
    }


    //Input: Board
    //Output: Boolean (True if the board is full, if an empty spot is found then returns false)
    public boolean tabelIsFull(Board board){
        boolean full = true;
        for(int i=1;i<10;i++){
            if(board.isOpen(i)){full = false;}
        }
        return full;
    }
}
