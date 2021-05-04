package gameStages;
import java.util.ArrayList;

public class gameStages {

    //Formats from arraylist to string
    public static String wordToMessage(ArrayList<Character> word){
        String message="";

        for(int i=0; i<word.size();i++){
            message =message + word.get(i)+" ";
        }

        return message;
    }
    //This method will print to console stage 0 of the game given the guesses and the correct word
    public static void gameStage0(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println("                 |                                                              ");
        System.out.println("                 |           Word: "+wordToMessage(output));
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 1 of the game given the guesses and the correct word
    public static void gameStage1(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println("  O              |                                                              ");
        System.out.println("                 |           Word: "+wordToMessage(output));
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 2 of the game given the guesses and the output
    public static void gameStage2(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println("  O              |                                                              ");
        System.out.println("  |              |           Word: "+wordToMessage(output));
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 3 of the game given the guesses and the word
    public static void gameStage3(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println("  O              |                                                              ");
        System.out.println("  |              |           Word: "+wordToMessage(output));
        System.out.println(" /               |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 4 of the game given the guesses and the word
    public static void gameStage4(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println("  O              |                                                              ");
        System.out.println("  |              |           Word: "+wordToMessage(output));
        System.out.println(" / \\             |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 5 of the game given the guesses and the word
    public static void gameStage5(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println(" \\O              |                                                              ");
        System.out.println("  |              |           Word: "+wordToMessage(output));
        System.out.println(" / \\             |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

    //This method will print to console stage 6 of the game given the guesses and the word
    public static void gameStage6(ArrayList<Character> guesses, ArrayList<Character> output){
        System.out.println("================================================================================");
        System.out.println("  +--------------+                                                              ");
        System.out.println("  |              |           Your guesses: "+guesses.toString()              );
        System.out.println(" \\O/             |                                                              ");
        System.out.println("  |              |           Word: "+wordToMessage(output));
        System.out.println(" / \\             |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("                 |                                                              ");
        System.out.println("_===================____________________________________________________________");
    }

}
