public class main {
    Land land;

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Land land = new Land();
        land.print();

        Human human = new Human();
        human.setPositionX(land.);
        human.setPositionY(0);

        land.spawn(human.getPositionX(),human.getPostitionY(), human);
        land.print();


    }
}
