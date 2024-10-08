import java.util.*;

public class Main  {

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
 public static void forest(){
        System.out.println("You have entered the mysterious forest");
        System.out.println("There is a  Giant ahead");
        System.out.println("1. Fight the Giant");
        System.out.println("2. Escape ");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int frt = scanner.nextInt();


        if(frt == 1){
            int x = random();
            if(x==0){
                System.out.println("Giant tear you apart");
                System.out.println("Your Score: "+ gamescore);
                restart();

            }
            else{
                System.out.println("Giant Defeated");
                gamescore = gamescore+SCORE_INCREMENT;
                System.out.println("Your Score: "+ gamescore);
                continuegame();
            }
        }
        else if(frt==2){
            healthscore-=20;
            System.out.println("Escaped Successfully");
            continuegame();
        }

    }

    public static void cave(){
        System.out.println("You have entered the dangerous cave");
        System.out.println("There is a monster sleeping ahead");
        System.out.println("1. Fight the Monster");
        System.out.println("2. Escape");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int cv = scanner.nextInt();


        if(cv == 1){
            int y = random();
            if(y==0){
                System.out.println("Monster Eat you alive");
                System.out.println("Your Score: "+ gamescore);
                restart();

            }
            else{
                System.out.println("Monster Defeated");
                gamescore = gamescore+SCORE_INCREMENT;
                System.out.println("Your Score: "+ gamescore);
                continuegame();
            }
        }
        else if(cv==2){
            healthscore-=20;
            System.out.println("Escaped Successfully");
            continuegame();
        }
    }
    public static void fort(){
        System.out.println("You have entered the Abandoned fort");
        System.out.println("There is a Rocky Creature ahead");
        System.out.println("1. Fight the Creature");
        System.out.println("2. Escape");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int fr = scanner.nextInt();

        if(fr == 1){
            int c = random();
            if(c==0){
                System.out.println("Rocky Creature Crushed you alive");
                System.out.println("Your Score: "+ gamescore);
                restart();

            }
            else{
                System.out.println("Rocky Creature Defeated");
                gamescore = gamescore+SCORE_INCREMENT;
                System.out.println("Your Score: "+ gamescore);
                continuegame();
            }
        }
        else if(fr==2){
            healthscore-=20;
            System.out.println("Escaped Successfully");
            continuegame();
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
