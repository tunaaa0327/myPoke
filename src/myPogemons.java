import java.util.*;

public class myPogemons {

    static Random random = new Random();

    static Scanner userInput = new Scanner(System.in);

    //variables
    String namePoki, skillOne, skillTwo, stun="";

    int HP, MP, choice;

    //Methods
    //Attack Option
    public void Attack() {
        System.out.println("\nChoose " + namePoki + " skills\n[1]" + skillOne + "\n[2]" + skillTwo + "\nOther");
        System.out.println("[3]Use Pogé Ball\nChoose Option: ");
        choice = userInput.nextInt();
        switch (choice) {
            case 1 -> SkillOne();
            case 2 -> SkillTwo();
            case 3 -> Catch();
        }
    }

    //Run Option
    public void Run(){
        choice = random.nextInt(1,10);
        if(choice <=6){
            System.out.println("You have failed to runaway from "+myMain.poge2.namePoki);
            Enemy();
        }else {
            System.out.println("You have successfully to runaway from "+myMain.poge2.namePoki);
            myMain.mainMenu();
        }
    }

    //Catch Option
    public void Catch(){
        if(myMain.poge2.HP>4){
            System.out.println("You have failed to catch "+myMain.poge2.namePoki);
            Enemy();
        }else {
            System.out.println("You have successfully catch "+myMain.poge2.namePoki);
            myMain.poge2.HP=10;
            myMain.mainMenu();
        }
    }


    public void SkillOne(){
        MP -= 1;
        System.out.println("\n"+namePoki + " uses " + skillOne);
        if (random.nextInt(1, 10) < 5) {
            choice = random.nextInt(3, 5);
            myMain.poge2.HP -= choice;
            System.out.println(skillOne + " has dealt critical damage");
            System.out.println(myMain.poge2.namePoki + " has received damage of " + choice);
        } else {
            myMain.poge2.HP -= 1;
            System.out.println(myMain.poge2.namePoki + " has received damage of 1");
        }if(stun.equals("yes")){
            System.out.println(myMain.poge2.namePoki+ " can't moved due to static" );
            stun = "no";
            Health();
        }else {
            Enemy();
        }
    }

    public void SkillTwo(){
        MP -= 1;
        System.out.println("\n"+namePoki + " uses " + skillTwo);
        if (random.nextInt(0, 3) < 1) {
            System.out.println(myMain.poge2.namePoki + " Feels dizzy");
            Enemy();
        } else {
            System.out.println(myMain.poge2.namePoki + " is stunned");
            stun = "yes";
            Attack();
        }
    }

    //Conditions
    public void Enemy(){
        if (random.nextInt(1, 3) == 1) {
            myMain.poge1.HP -= 1;
            System.out.println(myMain.poge2.namePoki + " uses " + myMain.poge2.skillOne);
            System.out.println(namePoki + " has received damage of 1");
        } else {
            myMain.poge1.HP -= 1;
            System.out.println(myMain.poge2.namePoki + " uses " + myMain.poge2.skillTwo);
            System.out.println(namePoki + " has received damage of 1");
        }
        Health();
    }

    public void Health(){
        System.out.println("\n"+namePoki + "\nHP: " + HP + "\nMP: " + MP);
        System.out.println(myMain.poge2.namePoki + "\nHP: " + myMain.poge2.HP);
        CaseHP();
    }

    public void CaseHP(){
        //Cases
        if(myMain.poge2.HP<=0){
            myMain.poge2.HP=10;
            System.out.println("You have defeated " + myMain.poge2.namePoki);
            myMain.mainMenu();
        }else if(myMain.poge1.HP<=0){
            System.out.println("Your "+namePoki+ "has been defeated");
            myMain.mainMenu();
        }else {
            Attack();
        }
    }



}