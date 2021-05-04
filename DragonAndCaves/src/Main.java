import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dragonStoryTime();
    }

    public static void dragonStoryTime(){
        int safe;

        //Random number 0 1
        safe =(int) Math.floor((Math.random()*2)+1);

        //Uncomment to see what the correct response is
        //System.out.println(safe);

        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into?\n\nEnter 1 for the cave to the left\n" +
                "Or 2 for the cave on the right");


        //Scan input
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input==safe){
            safeText();
            sleep(5000);
            System.out.println("---------------------------------------------------------");
            System.out.println("You made the right choice");
        }else{
            unsafeText();
            sleep(5000);
            System.out.println("---------------------------------------------------------");
            System.out.println("Yikes, maybe you should second guess your choice next time");
        }
    }

    public static void safeText(){
        //vars
        int textChoice =(int) Math.floor(Math.random()*3);
        int largePause = 2500;
        int mediumPause = 2000;
        int smallPause = 1000;

        switch (textChoice){
            case 0:
                System.out.println("You muster the courage and bolt into the cave\n");
                sleep(largePause);
                System.out.println("You see a blinding light in the distance, and run towards it\n");
                sleep(mediumPause);
                System.out.println("You cover your eyes with your hands to see an absurd amount of gold, weapons and loot\n");
                break;
            case 1:
                System.out.println("You enter the cave, and can hear the pitter patter of the water as it drips from " +
                        "the top of the cave...\n");
                sleep(largePause);
                System.out.println("Suddenly you can feel your right side becoming warm!! Instinctively you roll left " +
                        "bracing your self for certain doom. \n\n" +
                        "Curling into a ball you say your prayers \n");
                sleep(smallPause);
                System.out.println("Then the room goes cold again. The dragon was in the other cave and out of " +
                        "frustration tried to blast the cave wall down to get\n " +
                        "to you. You pick your self up and find mountains of gold. \n");
                break;
            case 2:
                System.out.println("You slowly walk your way into the cave, being very careful not to make any noise. Just one foot in front of the other slowly\n");
                sleep(largePause);
                System.out.println("... you keep walking ...\n");
                sleep(mediumPause);
                System.out.println("... you hear something hit the floor to your right\n");
                sleep(mediumPause);
                System.out.println("It is a trash bag filled to the brim with gold items covered in dust. The dragon must be doing its spring cleaning!" +
                        "\nYou throw it over your shoulder and come back out with your head held high!\n ");
        }

    }

    public static void unsafeText(){
        //vars
        int textChoiceUnsafe =(int) Math.floor(Math.random()*3);
        int largePause = 2500;
        int mediumPause = 2000;
        int smallPause = 1000;

        switch (textChoiceUnsafe){
            case 0:
                System.out.println("You muster the courage and bolt into the cave\n");
                sleep(largePause);
                System.out.println("You see a blinding light in the distance, and run towards it\n");
                sleep(largePause);
                System.out.println("You are burt to a crisp before you even realize what is happening. Didnt anyone " +
                        "tell you not to run towards the light?\n");
                break;
            case 1:
                System.out.println("You enter the cave, and can hear the pitter patter of the water as it drips " +
                        "from the top of the cave...\n");
                sleep(largePause);
                System.out.println("Suddenly you can feel your right side becoming warm!! Instinctively you roll " +
                        "left bracing your self for certain doom. \n" +
                        "Curling into a ball you say your prayers \n");
                sleep(mediumPause);
                System.out.println("You get up to see a dragon looking for its next meal looking straight at you. I dont " +
                        " think I have to explain the rest...\n");
                break;
            case 2:
                System.out.println("You slowly walk your way into the cave, being very careful not to make any noise. " +
                        "Just one foot in front of the other slowly\n");
                sleep(largePause);
                System.out.println("... you keep walking ...\n");
                sleep(largePause);
                System.out.println("... you hear something hit the floor. Then another, then another. THE CAVE IS " +
                        "COLLAPSING! You are buried alive.\n In " +
                        "grand scheme of things at least its better than being eaten alive.\n");
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
