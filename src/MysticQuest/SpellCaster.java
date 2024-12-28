package MysticQuest;

public class SpellCaster extends Character{
    SpellCaster (String name, int Hp, int MaxHp, int Damage,int Defend, int Energy, int MaxEnergy, int Intelligence, int Durability, int Strength){
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

