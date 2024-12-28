package MysticQuest;
import java.util.Scanner;


public class Main {
    public static void wait(int sec){
        try{
            Thread.sleep(sec * 1000);
        }
        catch(InterruptedException e){
        }
    }
    public static  void main(String[] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println("___   ___          _   _       ");
        System.out.println("|  \\/  |         | | (_)      ");
        System.out.println("| .  . |_   _ ___| |_ _  __ _ ");
        System.out.println("| |\\/| | | | / __| __| |/ _` |");
        System.out.println("| |  | | |_| \\__ \\ |_| | (_| |");
        System.out.println("\\_|  |_/\\__, |___/\\__|_|\\__, |");
        System.out.println("         __/ |             | |");
        System.out.println("        |___/              |_|");
        System.out.println("                       _      ");
        System.out.println("                      | |     ");
        System.out.println("  __ _ _   _  ___  ___| |_    ");
        System.out.println(" / _` | | | |/ _ \\/ __| __|   ");
        System.out.println("| (_| | |_| |  __/\\__ \\ |_    ");
        System.out.println(" \\__, |\\__,_|\\___||___/\\__|   ");
        System.out.println("    | |                       ");
        System.out.println("    |_|                       ");
        System.out.println("=====================WELCOME TO THE MYSTIC QUEST=====================");
        System.err.printf("What we gonna call you my Master : ");
        String NickName = input.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("entering game...");
        wait(3);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        StartGame.start(NickName);
        input.close();
    }


 

}


