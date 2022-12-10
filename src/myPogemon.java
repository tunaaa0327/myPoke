import java.util.*;

public class myPogemon {

    static Random random = new Random();

    static Scanner userInput = new Scanner(System.in);

    static int caught=0;

    //variables
    String namePoki, skillOne, skillTwo, stun="";

    int HP, MP, choice;
    //Methods

    //Attack Option
    public void Attack() {
        noHP();
        noMP();
        System.out.println();
        System.out.println("Choose " + namePoki + " skills\n[1]" + skillOne + "\n[2]" + skillTwo + "\nOther");
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
            caught=1;
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
        }System.out.println();
        Health();
        Attack();
    }
    public void Health(){
        System.out.println(namePoki + "\nHP: " + HP + "\nMP: " + MP);
        System.out.println(myMain.poge2.namePoki + "\nHP: " + myMain.poge2.HP);
    }

    public void SkillOne(){
        MP -= 1;
        System.out.println();
        System.out.println(namePoki + " uses " + skillOne);
        if (random.nextInt(1, 10) < 5) {
            choice = random.nextInt(3, 4);
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
            Attack();
        }else {
            Enemy();
        }
    }

    public void SkillTwo(){
        MP -= 1;
        System.out.println();
        System.out.println(namePoki + " uses " + skillTwo);
        if (random.nextInt(0, 3) < 1) {
            System.out.println(myMain.poge2.namePoki + " Feels dizzy");
            Enemy();
            Attack();
        } else {
            System.out.println(myMain.poge2.namePoki + " is stunned");
            stun = "yes";
            Attack();
        }

    }

    public void Potion(){

    }

    //Cases
    public void noMP() {
        if (MP <= 0) {
            System.out.println(namePoki + " has not enough Mana Point");
        }
    }

    public void noHP(){
        if (HP <= 0) {
            if(myMain.poge2.HP<=10){
                myMain.poge2.HP=10;
                System.out.println("You have killed " + myMain.poge2.namePoki);
            }else {
                noHP();
            }
        }

    }
}