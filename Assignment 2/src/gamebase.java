/*import java.util.*;

public class gamebase {

    public static final int INITIAL_HEALTH = 60;
    public static final int SCORE_INCREMENT = 20;

    public static int healthscore = INITIAL_HEALTH;
    public static int gamescore = 0;
    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Game");
        System.out.println();
        startgame();


    }
    public static void startgame(){
        if(healthscore>0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChoose your way carefully");
            System.out.println("Remaining Health:"+healthscore);
            System.out.println("1. Way to Mysterious Forest");
            System.out.println("2. Way to the Dangerous Cave");
            System.out.println("3. Way to Abandoned fort");

            System.out.println("Choose :");
            int way = scanner.nextInt();
            System.out.println();


            if (way == 1) {
                forest();
            } else if (way == 2) {
                cave();
            } else if (way == 3) {
                fort();
            } else {
                System.out.println("Wrong Way, Game Over");
            }

            scanner.close();
        }
        else
        {
            System.out.println("Game over , Insufficient Health");
        }
    }

    public static void continuegame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Continue");
        System.out.println("2. End the Game");
        System.out.println("Enter choice");

        int cg = scanner.nextInt();
        if(cg==1){
            startgame();
        }
        else{
            System.out.println("Game Over");
            System.out.println("Your Health Score:"+ healthscore);
            System.out.println("Your Collected Score:"+ gamescore);

        }


    }
    public static void restart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 . Restart Game");
        System.out.println("2. Leave Game");
        System.out.println("Enter choice");
        int rt = scanner.nextInt();
        if(rt==1){
            healthscore = INITIAL_HEALTH;
            gamescore = 0;
            startgame();
        }
        else{
            System.out.println("Game Over");
            System.out.println("Your Health Score:"+ healthscore);
            System.out.println("Your Collected Score:"+ gamescore);

        }


    }


    public static int random(){
        Random rand = new Random();
        int ran = rand.nextInt(2);
        return ran;
    }

}
*/