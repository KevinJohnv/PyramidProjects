import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessingGame();
    }

    public static void guessingGame(){
        System.out.println("\n\n======================================================================================================\n");
        System.out.println("You wander into a pollen covered tent in the outskirts of Atlanta." +
                "'GUESTS!!!! GUEST!!! GUEST!!! GUESTs!!! I mean welcome to my magic show!', you hear from the back of the tent.\n" +
                "The sound is coming from this bowling pin shaped man.\n" +
                "'Give me one second I need to go find my deck of cards', he says in a fast paced voice.");
        sleep(12000);
        System.out.println("\n\n'Here they are. Let me show you how great of a magician I am, in this trick I will make you say the card I want you to say" +
                ". So you hold this deck of cards," +
                "and ill pick a card (0-13) and then \nyou have to guess it sound good?' before you could reply he jams the cards in your hands.");
        sleep(10000);
        Scanner scanner = new Scanner(System.in);

        boolean play = true;
        while(play){
            System.out.println("\nYou fan them out and he grabs one and a toothles grin appears on his face. 'Okay now guess'");

            int card =(int) Math.floor(Math.random() * (13-0) + 0);

            boolean guessed = false;
            System.out.println(card);
            while(guessed == false){
                int guess = scanner.nextInt();
                if(card == guess){
                    System.out.println("'I amaze myself', he bellows 'you got it right! Thanks for entertaining me. " +
                            "Do you want to play again?\n================\nany key to contiue\nN to exit\n================" );
                    String again = scanner.next();
                    if(again.charAt(0) == 'N'){
                        System.out.println("Shame, well I guess Ill see you later then!");
                        play=false;
                    }
                    guessed=true;
                }else{
                    if(guess > card){
                        System.out.println("Too high, go lower.\n");
                    }else{
                        System.out.println("Too low, higher.\n");
                    }
                }
            }
        }
    }

    public static void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}


