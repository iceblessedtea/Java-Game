package MysticQuest;
import java.util.Scanner;

public class StartGame {
    public static void start(String NickName){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
        System.out.println("======== " +"HOLA MASTER " + NickName + " WELCOME TO THE MYSTIC QUEST" + "========");
        System.out.println( "1.Knight");
        System.out.println( "2.Archer");
        System.out.println( "3.SpellCaster");
        System.out.printf("Please select your champion : ");
        int champion = input.nextInt();
        switch (champion){
            case 1:
            Knight Godfrey = new Knight("Godfrey", 200, 200, 30, 40, 100, 1, 1, 1,1);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("Go to Village...");
            Wait.wait(2);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Godfrey.Village();
            break;
            case 2:
            Archer Lucy = new Archer("Lucy", 100, 100, 20, 70, 90,90,1,1,1);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Lucy.Village();
            running =  false;
            break;
            case 3:
            SpellCaster bellingham = new SpellCaster("Bellingham",80,80,50,20,120,120,1,1,1);
            bellingham.Village();
            break;
            default:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("that was an invalid input master ! ");
            System.out.println("please input a valid command master !!! \n");
            break;
        }
    }
        input.close();
    }
}
