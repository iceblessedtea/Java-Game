package MysticQuest;

public class Monster{
    String name;
    int Hp;
    int Damage;
    int dropHpPot;
    int dropexp;

     Monster(String name, int Hp, int Damage, int dropHpPot,int dropexp){
        this.name = name;
        this.Hp = Hp;
        this.Damage = Damage;
        this.dropHpPot = dropHpPot;
        this.dropexp = dropexp;
    }
}