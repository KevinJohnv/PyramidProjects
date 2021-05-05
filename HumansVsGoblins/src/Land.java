import java.util.Arrays;

public class Land {
    int[][] land = new int[3][3];

    public Land(){
        for (int[] row: land)
            Arrays.fill(row, 0);
    }

    public void move(int x, int y, Creature creature){
        if(land[x][y]!=0){
            System.out.println("2 things have clashed");

        }else{}
        creature.setPositionX(x);
        creature.setPositionY(y);
    }

    public void peek(int x, int y){
        if(land[x][y]!=0){
            System.out.println("there is something there");

        }else{}
    }

    public void print(){
        for (int[] x : land)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}
