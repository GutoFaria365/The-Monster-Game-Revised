package Supernaturals;
import GameEngine.Utilities;

public class Vampire extends Monster {
    public Vampire(String name, int attackPower, int health) {
        super(name, attackPower, health);

    }
    public Vampire () {
        this.name = "Supernaturals.Vampire";
        this.attackPower = 20;
        this.health = 100;
        this.isDead = false;
    }

    @Override
    public void monsterAttack(Monster monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() + " for " + this.getAttackPower() + "  points of damage!");

        //small chance of recovering health
        int healthBoost = Utilities.generateGuessingNumber(1,10);
        if(healthBoost == 10) {
            System.out.println("Health Boost!!!");
            this.health+= 20;
        }
        monster.isDead();
    }
}
