import java.util.*;

public class level1  {

    public static final int INITIAL_HEALTH = 60;
    public static final int SCORE_INCREMENT = 20;

    public static int healthscore = INITIAL_HEALTH;
    public static int gamescore = 0;
    public static String selectedWeapon = "";
    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Game");
        System.out.println();
        startgame();


    }
    public static void startgame(){
        if(healthscore>0) {
            selectedWeapon = "";
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
                selectedWeapon = selectweapon();
                forest(selectedWeapon);
            } else if (way == 2) {
                selectedWeapon = selectweapon();
                cave(selectedWeapon);
            } else if (way == 3) {
                selectedWeapon = selectweapon();
                fort(selectedWeapon);
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
    public static String selectweapon(){
        System.out.println("You have found the treasure Box");
        System.out.println("1. Trade 10 health to open the treasure box");
        System.out.println("2. Proceed without trading");

        Scanner scanner = new Scanner(System.in);
        int sw = scanner.nextInt();
        String weapon = "";
        if(sw == 1){
            healthscore-=10;
            if (healthscore <= 0) {
                restart();
            }
            weapon = getRandomWeapon();
            System.out.println("You traded health for a weapon and received: " + weapon);
            System.out.println("Remaining health: " + healthscore);
            return weapon;
        }
        else if(sw == 2){
            System.out.println("You decided to proceed without a new weapon.");
            return weapon;
        }
        else{
            return weapon;
        }

    }
    public static void forest(String SelectedWeapon){
        System.out.println("You have entered the mysterious forest");
        System.out.println("There is a Tree Giant ahead");
        System.out.println("1. Fight the Tree Giant");
        System.out.println("2. Escape ");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int frt = scanner.nextInt();
        String RequiredWeapon = "Sword";

        if(frt == 1){
            if(RequiredWeapon.equals(SelectedWeapon)){

                System.out.println("Tree Giant Defeated");
                gamescore = gamescore+SCORE_INCREMENT;
                System.out.println("Your Score: "+ gamescore);
                continuegame();
            }
            else if(SelectedWeapon == ""){
                System.out.println("Tree Giant tear you apart");
                System.out.println("Your Score: "+ gamescore);
                restart();
            }
            else {
                System.out.println("Your " + SelectedWeapon + " is ineffective against the tree Giant...");
                healthscore -= 20;
                System.out.println("The tree Giant dealt damage! Remaining health: " + healthscore);
                if (healthscore <= 0) {
                    restart();
                }
                continuegame();
            }

        }
        else if(frt==2){
            healthscore-=20;
            System.out.println("Escaped Successfully");
            continuegame();
        }

    }

    public static void cave(String SelectedWeapon){
        System.out.println("You have entered the dangerous cave");
        System.out.println("There is a monster sleeping ahead");
        System.out.println("1. Fight the Monster");
        System.out.println("2. Escape");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int cv = scanner.nextInt();
        String RequiredWeapon = "Bow";

            if(cv == 1){
                if(RequiredWeapon.equals(SelectedWeapon)){

                    System.out.println("Monster Defeated");
                    gamescore = gamescore+SCORE_INCREMENT;
                    System.out.println("Your Score: "+ gamescore);
                    continuegame();
                }
                else if(SelectedWeapon == ""){
                    System.out.println("Monster Eat you alive");
                    System.out.println("Your Score: "+ gamescore);
                    restart();
                }
                else {
                    System.out.println("Your " + SelectedWeapon + " is ineffective against the Monster...");
                    healthscore -= 20;
                    System.out.println("The Monster dealt damage! Remaining health: " + healthscore);
                    if (healthscore <= 0) {
                        restart();
                    }
                    continuegame();
                }

            }
        else if(cv==2){
            healthscore-=20;
            System.out.println("Escaped Successfully");
            continuegame();
        }
    }
    public static void fort(String SelectedWeapon){
        System.out.println("You have entered the Abandoned fort");
        System.out.println("There is a Rocky Creature ahead");
        System.out.println("1. Fight the Creature");
        System.out.println("2. Escape");

        System.out.println("Choose wisely:");

        Scanner scanner = new Scanner(System.in);
        int fr = scanner.nextInt();

        String RequiredWeapon = "Magic Staff";

        if(fr == 1){
            if(RequiredWeapon.equals(SelectedWeapon)){

                System.out.println("Rocky Creature Defeated");
                gamescore = gamescore+SCORE_INCREMENT;
                System.out.println("Your Score: "+ gamescore);
                continuegame();
            }
            else if(SelectedWeapon == ""){
                System.out.println("Rocky Creature Crushed you alive");
                System.out.println("Your Score: "+ gamescore);
                restart();
            }
            else {
                System.out.println("Your " + SelectedWeapon + " is ineffective against the Rocky Creature...");
                healthscore -= 20;
                System.out.println("The Rocky Creature dealt damage! Remaining health: " + healthscore);
                if (healthscore <= 0) {
                    restart();
                }
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

    private static String getRandomWeapon() {
        String[] weapons = {"Sword", "Bow", "Magic Staff"};
        int randomIndex = new Random().nextInt(weapons.length);
        return weapons[randomIndex];
    }

  /*  public static int random(){
        Random rand = new Random();
        int ran = rand.nextInt(2);
        return ran;
    }*/

}
