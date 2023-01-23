package Supernaturals;

public class Werewolf extends Monster {
    public Werewolf(String name, int attackPower, int health) {
        super(name, attackPower, health);
        //no special
    }
    public Werewolf() {
        this.name = "Supernaturals.Werewolf";
        this.attackPower = 20;
        this.health = 120;
        this.isDead = false;
    }

    @Override
    public void monsterAttack(Monster monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() +" for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
    }
}
