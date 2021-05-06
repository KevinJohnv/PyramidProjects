public class main {
    Land land;

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Land land = new Land();
        land.print();

        Human human = new Human(land);
        land.print();
        System.out.println(human.toString());

        Goblin goblin = new Goblin(land);
        System.out.println(goblin.toString());
        land.print();

        human.move(land,"w");
        land.print();


    }
}
