import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import gameStages.gameStages;

public class Main {
    public static void main(String[] args) {
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        //Hello

        while(play){
            start();
            System.out.println("Wanna go again(Y/N)");

            boolean invalid = false;
            do{
                String input = scanner.next();
                if(input.equalsIgnoreCase("N")){
                    play =false;
                    invalid = false;
                }else if(input.equalsIgnoreCase("Y")){
                    play = true;
                    invalid = false;
                }else{
                    System.out.println("You make no sense, its a y or n question");
                    invalid=true;
                }
            }while(invalid);
        }
    }

    public static void start(){

        //variables
        boolean gameover = false;
        boolean win = false;
        int gamestage = 0;
        ArrayList<Character> guesses = new ArrayList<>();
        String word = new String();
        ArrayList<Character> output = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Greeting
        System.out.println("Welcome to Hangman. Lets play. I am thinking of a word, guess letters below and we can go from there");

        //Setup
        word = wordBank();
        System.out.println(word);//------------------------------------------------------------------------------------------------------
        for(int i =0; i<word.length();i++){
            output.add('_');
        }

        gameStages.gameStage0(guesses,output);

        String input;
        //Game loop
        while(!gameover && !win){
            input = scanner.next().toLowerCase();

            if(input.length() == 1){
                int checker = check(input.charAt(0), word,guesses);

                if(checker == 0){
                    //Guess is correct
                    for(int i=0; i<word.length();i++){
                        if(input.charAt(0) == word.charAt(i)){
                            output.set(i,input.charAt(0));
                        }
                    }
                    guesses.add(input.charAt(0));

                } else if(checker == 1){
                    //Guess is incorrect
                    guesses.add(input.charAt(0));
                    gamestage++;
                }else{
                    System.out.println("\n\n You've already tried that one");
                }
                switch(gamestage){
                case 0:
                    gameStages.gameStage0(guesses,output);
                    break;
                case 1:
                    gameStages.gameStage1(guesses,output);
                    break;
                case 2:
                    gameStages.gameStage2(guesses,output);
                    break;
                case 3:
                    gameStages.gameStage3(guesses,output);
                    break;
                case 4:
                    gameStages.gameStage4(guesses,output);
                    break;
                case 5:
                    gameStages.gameStage5(guesses,output);
                    break;
                case 6:
                    gameStages.gameStage6(guesses,output);
                    gameover = true;
                    break;
             }
                System.out.println("Exited switch");//------------------------------------------------------------------------------------------------------
                //Check to see if the output is now the same as the word and end game with win if so
                int count=0;
                for(int i=0; i<word.length();i++){
                    if(output.get(i) == word.charAt(i)){
                        count++;
                    }
                }

                if(count == word.length()){win=true;}

            }else{
                System.out.println("Come on now, I just need one letter... Or a number if your just trying to kill him");
            }


        }

        if(gamestage==6){
            System.out.println("\n\nBetter luck next time I guess, but RIP that guy...");
        }else{
            System.out.println("\n\nYou really did it...\nDEFINETlY thought that dude was a goner. Who would have thought the word "+word+" would save him.\n" +
                    "In hindsight this is such a weird game");
        }


    }

    //Input: char, Arraylist<Char>, ArrayList<Char>
    //Output:bool
    //This method will take in a char, it will check if it has been guessed before. If not they it will check to see if
    //it is in the mystery word. It will return a 0 if the guess was correct, 1 if the guess was wrong, and 2 if the guess was guessed before

    public static int check(Character guess, String word, ArrayList<Character> guessed){
        boolean unique = true;
        boolean correct = false;
        int i = 0;

        //Checks to see if the guess has been guessed before
        while(unique == true && i<guessed.size()){
            if(guess == guessed.get(i)){
                unique = false;
            }
            i++;
        }

        //If unique check to see if it is in the word
        if(unique){
            i=0;
            while(correct == false && i<word.length()){
                if(guess == word.charAt(i)){
                    correct = true;
                }
                i++;
            }

            if(correct){
                return  0;
            }else{
                return 1;
            }
        }else{
            return 2;
        }
    }

    //Returns a random pregenerated word
    public static String wordBank(){
        String[] wordArr = {"dog","cat","bird","table","ox","is","rings","baby"};
        int rand =(int) Math.floor(Math.random()*10);

        return  wordArr[rand];
    }






}
