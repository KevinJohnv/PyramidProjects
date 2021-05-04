package Board;

public class Board {
    public String board;
    public String pos1 = " ";
    public String pos2 = " ";
    public String pos3 = " ";
    public String pos4 = " ";
    public String pos5 = " ";
    public String pos6 = " ";
    public String pos7 = " ";
    public String pos8 = " ";
    public String pos9 = " ";

    public Board(){
        updateBoard();
    }

    //Updates board based of of the current values
    public void updateBoard(){
        board= pos1+" | "+pos2+" | "+pos3+" \n"+pos4+" | "+pos5+" | "+pos6
                +" \n"+pos7+" | "+ pos8+" | "+pos9+" ";
    }

    //Input: Location(int)
    //OUtput: Bool
    //Description: Takes in a int that specifies to a location on the board and return true if the area is empty and can be
    // played on or false if it cannot be played on
    public boolean isOpen(int i){
        switch (i){
            case 1: if(pos1.equals(" ")){return true;}else{return false;}

            case 2: if(pos2.equals(" ")){return true;}else{return false;}

            case 3: if(pos3.equals(" ")){return true;}else{return false;}

            case 4: if(pos4.equals(" ")){return true;}else{return false;}

            case 5: if(pos5.equals(" ")){return true;}else{return false;}

            case 6: if(pos6.equals(" ")){return true;}else{return false;}

            case 7: if(pos7.equals(" ")){return true;}else{return false;}

            case 8: if(pos8.equals(" ")){return true;}else{return false;}

            case 9: if(pos9.equals(" ")){return true;}else{return false;}

        }
        return false;
    }


    //Input: playerID, move
    //Output: void
    //Description: This is used to commit a move to the board. It will auto check to see if the move is possible
    public void placeMove(String playerID, int move){
        if(isOpen(move)){
            //Places the move depending on the player ID
            String c = "Computer";
            switch (move){
                case 1: if(playerID.equalsIgnoreCase(c)){pos1 ="O";}else{pos1 ="X";}
                    break;
                case 2: if(playerID.equalsIgnoreCase(c)){pos2 ="O";}else{pos2 ="X";}
                    break;
                case 3: if(playerID.equalsIgnoreCase(c)){pos3 ="O";}else{pos3 ="X";}
                    break;
                case 4: if(playerID.equalsIgnoreCase(c)){pos4 ="O";}else{pos4 ="X";}
                    break;
                case 5: if(playerID.equalsIgnoreCase(c)){pos5 ="O";}else{pos5 ="X";}
                    break;
                case 6: if(playerID.equalsIgnoreCase(c)){pos6 ="O";}else{pos6 ="X";}
                    break;
                case 7: if(playerID.equalsIgnoreCase(c)){pos7 ="O";}else{pos7 ="X";}
                    break;
                case 8: if(playerID.equalsIgnoreCase(c)){pos8 ="O";}else{pos8 ="X";}
                    break;
                case 9: if (playerID.equalsIgnoreCase(c)){pos9 = "O";}else{pos9="X";}
                    break;
            }
        }else{
            System.out.println("Select a differenet tile. That one is already in use");
        }

    }

    public void print(){
        updateBoard();
        System.out.println(this.board+"\n\n--------------------------------------------------\n");
    }


}
