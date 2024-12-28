package MysticQuest;
import java.util.Random;
import java.util.Scanner;


abstract class Character {
    String name;
    private int Hp;
    private int  MaxHp;
    int Damage;
    int Energy;
    int MaxEnergy;
    int Intelligence;
    int Strength;
    int Defend;
    int Durability;
    int HealthPotion;
    int Exp = 0;
    int Maxexp = 100;
    int lv = 1;


    public void DisplayInfoStats() {
        System.out.println("=========================STATS=========================");
        System.out.println("character name \t: " + name);
        System.out.println("Exp \t\t: " + this.Exp  + "/" + this.Maxexp);
        System.err.println("Level \t\t: " + this.lv);
        System.out.println("Health \t\t: " + getHp() + "/" + getMaxHp());
        System.out.println("Energy \t\t: " + Energy + "/" + MaxEnergy);
        System.out.println("Damage \t\t: " + this.Damage);
        System.out.println("Defend \t\t: " + this.Defend);
        System.out.println("Strength \t: " + this.Strength);
        System.out.println("Intelligence \t: " + this.Intelligence);
        System.out.println("Durability \t: " + this.Durability);


    }
    

    public void DisplayInventory(){
        System.out.println("======================INVENTORY======================");
        System.out.println("Health Potion : " + HealthPotion);
        System.out.println("");
    }

    //getter
    public int getHp(){
        return this.Hp;
    }
    public int getMaxHp(){
        return this.MaxHp;
    }

    //setter
    public void setHp(int Hp){
        this.Hp = Hp;
    }
    public void setMaxHp(int MaxHp){
        this.MaxHp = MaxHp;
    }

    public void HealPotion(){
        if (HealthPotion <= 0){
            System.out.println("you dont have any health potion master !!");
            Wait(3);
            
        }
        else{
            setHp(getMaxHp());
            System.out.println("Your champion's Health is restored");
            Wait(3);
        }
    }

    //attack monster
    public void AttackMonster(Monster monster){
        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("a monster is appear near you master ");
        System.out.println("you meet " + monster.name+ " Master.");
        Wait(3);
                while (monster.Hp  > 0){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.err.println("");
                    System.out.println(name + "\t\t\t" + monster.name);
                    System.out.println(getHp() + "\t\t\t" + monster.Hp + "\n");
                    System.out.println("1. Attack");
                    System.out.println("2. Heal");
                    System.out.printf("what you gonna do master : ");
                        int choice = input.nextInt();
                            switch (choice) {
                            case 1:
                                monster.Hp = monster.Hp - Damage;
                                System.out.println("you hit " + monster.name);
                                Wait(3);
                                if (monster.Hp <= 0 ){
                                    System.out.print("\033[H\033[2J");  
                                    System.out.flush();
                                    System.out.println("you defeated a " + monster.name + " master");
                                    this.Exp += monster.dropexp;
                                    this.HealthPotion += monster.dropHpPot;
                                    System.out.println("you got " + monster.dropexp + "exp");
                                    System.out.println("you got " + monster.dropHpPot + "health potion");
                                    increasedexp(Exp);
                                    System.out.println("1. Go through forest");
                                    System.out.println("2. Back to village");
                                    System.out.println("3. Exit game");
                                    System.out.printf("what you gonna do master:");
                                    int choice2 = input.nextInt();
                                    switch (choice2) {
                                        case 1:
                                        System.out.print("\033[H\033[2J");  
                                        System.out.flush();
                                            System.out.println("exploring forest...");
                                            Wait(1);
                                            Forest();
                                            break;
                                        case 2:
                                        System.out.print("\033[H\033[2J");  
                                        System.out.flush();
                                            System.out.println("exiting forest..");
                                            Wait(1);
                                            Village();
                                        case 3:
                                        System.out.print("\033[H\033[2J");  
                                        System.out.flush();
                                        ExitGame.ExitGamee();

                                        default:
                                            break;
                                    }
                                }
                                else {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                System.out.println(monster.name + " attack you now master !!!");
                                System.out.println("1. Left \n2. Right");
                                System.out.printf("choose side to dodge : ");
                                Random rand = new Random();
                                int choice1 = input.nextInt();
                                int dodgechance = rand.nextInt(3);
                                Wait(1);
                                if (dodgechance == choice1){
                                    System.out.println("you dodge the " + monster.name + " attack master!!!");
                                    Wait(1);
                                    if(getHp() <= 0 ){
                                        GameOver();        
                                    }
                                }
                                else{
                                    int Hpp = getHp() +this.Defend - monster.Damage;
                                    setHp(Hpp);
                                    System.out.println("you failed to dodge master, "+ monster.name +" attack you ");
                                    Wait(1);
                                    if(getHp() <= 0 ){
                                        GameOver();        
                                    }
                                }
                                }
                            break;
                            case 2:
                                HealPotion();
                                break;
                            default:

                            break;
                            }
                    }
        input.close();
    }
    
    //gameover metho
    public void GameOver(){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("================GAME OVER================");
        System.out.println("You face the god ");
        System.out.println("now played skyfall -adele \n");
        System.out.printf("do you want to restart the game master (y/n) : ");
        String choice = input.nextLine();
        char character = choice.charAt(0);
        switch (character) {
            case 'y':
                System.out.println("Restarting the game...");
                Wait(2);

                break;
            case 'n':
                ExitGame.ExitGamee();
                running = false;
                break;
            default:
                System.out.println("please make a valid input master!!!");
                break;
        }
    }
        System.out.println();
        input.close();;
    }


    //exit game method

    //wait
    public static void Wait(int sec){
        try{
            Thread.sleep(sec * 1000);
        }
        catch(InterruptedException e){
        }
    }

    public void Increasedlevel(){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running){
        System.out.println("your level has been increased master");
        System.out.println("now you can upgrade your stats");
        System.out.println("1. Strength \t: " + this.Strength + "(damage + 30)");
        System.out.println("2. Intelligence \t: " + this.Intelligence + "(energy + 30)");
        System.out.println("3. Durability \t: " + this.Durability + "(defend + 30)");
        System.out.printf("please Select what you gonna do master : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                this.Strength++;
                this.Damage += 30;
                System.out.println("your strength has been increased master!");
                break;
            case 2:
                this.Intelligence++;
                this.Energy += 30;
                System.out.println("your Energy has been increased master!");
                break;
            case 3:
                this.Durability++;
                this.Defend += 30;
                System.out.println("your Energy has been increased master!");
            break;
            default:
            System.out.println(" please make a valid input master !!! ");
                break;
        }
        input.close();
        }
        
    }

    public void increasedexp(int expp){
        this.Exp = expp;
        if (this.Exp == 100 ){
            lv ++;
            this.Exp = 0;
            Increasedlevel();
        }
        else{
            System.out.println("your exp has been increased master");
            System.out.println("Exp : " + this.Exp + "/" + this.MaxHp );
        }

    }

    public void Village(){
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    Scanner input = new Scanner(System.in);
    boolean running =  true;
    while (running){
    System.out.println("====================VILLAGE====================");
    System.out.println("1. Home");
    System.out.println("2. Forest");
    System.out.println("3. Exit game");
    System.out.printf("Where  you gonna go Master : ");
    int choice = input.nextInt();
    switch (choice) {
        case 1:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Home();
            break;
        case 2:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("Go to forest...");
            Wait(2);
            Forest();
            break;
        case 3:
            ExitGame.ExitGamee();
            running = false;
            break;
        case 5:
            ExitGame.ExitGamee();

        default:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("Please make a valid input master !!! ");

            break;
    }
    input.close();
    }
    }

    public void Home(){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running){
        System.out.println("");
        System.out.println("====================HOME====================");
        System.out.println("1. Sleep (healing Hp, took a several minute )");
        System.out.println("2. Display Stats");
        System.out.println("3. Display Inventory");
        System.out.println("4. Exit Home");
        System.out.printf("what you gonna do master : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                setHp(getMaxHp());
                Energy = MaxEnergy;
                System.out.println("sleeping...");
                Wait(5);
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("your Hp and Energy has been increased master");
                Home();
                break;
            case 2:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                DisplayInfoStats();
                Home();
                break;
            case 3:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                DisplayInventory();
                Home();
                break;
            case 4:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                Village();
                running = false;
                break;
            default:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\nPlease make a valid input master !!!");
                break;
        }        
    }
            input.close();
    }

    public void Forest(){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        boolean running = true;
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while(running){
        System.out.println("====================FOREST====================");
        System.out.println("1. Exploring forest");
        System.out.println("2. Go back to village");
        System.out.printf("what you gonna do master : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Monster monster1 = new Monster("skeleton", 100, 30, 1, 20);
                Monster monster2 = new Monster("Orc", 120, 25, 1, 20);
                Monster monster3 = new Monster("Witch",100,40,2,45);
                Monster monster4 = new Monster("Razor", 100, 35, 2, 50);
                Monster monster5 = new Monster("Goblin",90, 20, 1, 15);
                int monspawn = rand.nextInt(5);
                switch (monspawn) {
                    case 0:
                        AttackMonster(monster1);
                        break;
                    case 1:
                        AttackMonster(monster2);
                        break;
                    case 2:
                        AttackMonster(monster3);
                        break;
                    case 3:
                        AttackMonster(monster4);
                    case 4:
                        AttackMonster(monster5);
                    default:
                    
                        break;
                }
                break;
            case 2: 
                Wait.wait(2);
                System.out.println("Back to village..");
                Village();
                running = false;
            default:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("please make a valid input master !!! ");
                break;
        }
    }
    input.close();
    
}

    public void ExploreForest(){
        boolean running = true;
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while (running){
        Scanner input =new Scanner(System.in);
        System.out.println("1. Go exploring forest ");
        System.out.println("2. Return to village");
        System.out.printf("where you gonna go master : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println(" exploring forest ");
                Forest();
                break;
            case 2:
                Village();
                running = false;
                break;
            default:
                System.out.println("please make a valid input master !!! ");
                break;
        }
        input.close();
    }
    }
    
    }

