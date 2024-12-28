package MysticQuest;


public class Knight extends Character{
    
    //constructor
    Knight (String name, int Hp, int MaxHp, int Damage,int Defend, int Energy, int MaxEnergy, int Intelligence, int Durability, int Strength){
        // super.(name,setHp(Hp),setMaxHp(MaxHp),Damage,Defend,Energy,MaxEnergy,Strength,Intelligence,Durability);
        this.name = name;
        setHp(Hp);
        setMaxHp(MaxHp);
        this.Damage = Damage;
        this.Defend = Defend;
        this.Energy = Energy;
        this.MaxEnergy = MaxEnergy;
        this.Strength = Strength;
        this.Intelligence = Intelligence;
        this.Durability =  Durability;
    }
}

