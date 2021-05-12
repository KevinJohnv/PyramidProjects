import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        //Game Loop
        String command = " ";
        boolean game = true;
        while(!command.equalsIgnoreCase("exit")){
            game = true;

            System.out.println("New Game Started!(Type exit to leave)");

            Land land = new Land();
            Human human = new Human();
            Goblin goblin = new Goblin();
            Scanner scanner = new Scanner(System.in);

            //Spawn in the creatures into the land into the land
            land.spawn(human);
            land.spawn(goblin);


            while(game){
                try{
                    //Human movement------------------------------------------------------------------------------------
                    System.out.println(land.toString()+"\n"+human.toString());
                    System.out.println("Enter N/S/E/W to move or exit to leave");
                    command = scanner.next();
                    //Checks if the command inputed was a direction, exit statment or none of the above
                    if(command.equalsIgnoreCase("n")||command.equalsIgnoreCase("s")||
                            command.equalsIgnoreCase("e")||command.equalsIgnoreCase("w")){

                        //Checks if desired location is available
                        int check = land.peek(human,command);
                        if(check == 0){
                            System.out.println("You have hit a wall");
                        }else if(check == 1){
                            System.out.println("You have run right into the goblin's handsn" +
                                    "\n\nGAME OVER\n");
                            game = false;
                            //End case
                        }else if (check == 2){
                            land.move(human,command);
                        }else{
                            System.out.println("I honestly do know know what you have done to reach this point");
                        }

                    }else if(!command.equalsIgnoreCase("exit")){
                        //Messages in case the command was none of the expected values
                        System.out.println("Invalid command try again");
                    }else{
                        game = false;
                    }

                    //Goblin movement---------------------------------------------------------------------------------
                    if(human.getRow() == goblin.getRow()){
                        //Move column
                        if(human.getColumn() > goblin.getColumn()){
                            land.move(goblin,"e");
                        }else if(human.getColumn() < goblin.getColumn()){
                            land.move(goblin,"w");
                        }
                    }else{
                        //Move row
                        if(human.getRow()<goblin.getRow()){
                            land.move(goblin,"n");
                        }else if(human.getRow()> goblin.getRow()){
                            land.move(goblin,"s");
                        }
                    }

                    if(human.getRow() == goblin.getRow() && human.getColumn() == goblin.getColumn()){
                        //Goblin is on human end game
                        System.out.println("The goblin pounces on you and has eaten you rip\n\nGAME OVER\n\n");
                        game = false;
                    }
                }catch (Exception e){
                    System.out.println("Invalid input try again");
                }



            }
        }


    }

}
