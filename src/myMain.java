import java.util.*;

public class myMain {

    //Object
    static myPogemons poge1 = new myPogemons();
    static myPogemons poge2 = new myPogemons();



    //Variables
    static Scanner userInput = new Scanner(System.in);
    static Random random = new Random();
    static String choice="2";


    public static void main(String[] args) {

        //Pokémon #1 Attributes
        poge1.namePoki = "Pikachu";
        poge1.skillOne = "Thunderbolt";
        poge1.skillTwo = "Static";
        poge1.HP = 20;
        poge1.MP = 10;

        //Pogémon #2 Attributes
        poge2.namePoki = "Snorlax";
        poge2.skillTwo = "Smash";
        poge2.skillOne = "Stump";
        poge2.HP = 10;
        poge2.MP = 10;

        System.out.println("Welcome to Pogemon");
        mainMenu();

    }

    //Menu
    public static void mainMenu(){
            System.out.println();
            while (!choice.equals("3")) {
                System.out.println("[1]Move\n[2]Rest\n[3]Quit\nChoose your Option: ");
                choice = userInput.next();
                switch (choice) {
                    case "1" -> Move();
                    case "2" -> Rest();
                    case "3" -> System.out.println("Thank You For playing Pogemon");
                    default -> {
                        System.out.println("No Error Trapping");
                        mainMenu();
                    }
                }
            }
    }//End_Menu


    //Move
    public static void Move() {
        System.out.println();
        if (random.nextInt(1, 10) <6) {
            System.out.println("You have move " + choice + " blocks");
        }else{
            System.out.println("You have encountered a wild " + poge2.namePoki);
            System.out.println("[1] Attack\n[2] Run\n[3] Catch\nChoose your option: ");
            choice = userInput.next();
            switch (choice) {
                case "1" -> poge1.Attack();
                case "2" -> poge1.Run();
                case "3" -> poge1.Catch();
                default -> {
                    System.out.println("No Error Trapping");
                    Move();
                }
            }
        }
    }


    //Rest
    public static void Rest(){
        if (poge1.HP == 20) {
            System.out.println("\n"+poge1.namePoki + " is already in full health");
            System.out.println();
            mainMenu();
        } else {
            poge1.HP = 20;
            poge1.MP = 10;
            System.out.println("\n"+poge1.namePoki + " has restored its health and mana" + "\nHP: " + poge1.HP + "\nMP:" + poge1.MP);
            mainMenu();
        }
    }


}
