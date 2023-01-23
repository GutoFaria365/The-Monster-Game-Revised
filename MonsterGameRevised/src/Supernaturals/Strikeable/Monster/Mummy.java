package Supernaturals.Strikeable.Monster;
import GameEngine.Game;
public class Mummy extends Monster {
   public  int countAttacks = 0;
   public  int consecutiveAttack = 0;

    public Mummy(String name, int attackPower, int health) {
        super(name, attackPower, health);

    }
    public Mummy() {
        this.name = "Supernaturals.Strikeable.Monster.Mummy";
        this.attackPower = 30;
        this.health = 80;
        this.isDead = false;

    }
    @Override
    public void monsterAttack(Monster monster) {
        if (this.consecutiveAttack == 0) {
            this.consecutiveAttack = Game.roundCount;
            this.countAttacks += 1;
            System.out.println(this.countAttacks + "a" + "round1a" + this.consecutiveAttack + Game.roundCount);
        } else if (Game.roundCount - consecutiveAttack == 1) {
            this.consecutiveAttack = Game.roundCount;
            this.countAttacks += 1;
            System.out.println(this.countAttacks + "a" + "round2a" + this.consecutiveAttack + Game.roundCount);
        } else {
            System.out.println(this.countAttacks + "a" + "round4a" + Game.roundCount);
            this.countAttacks = 0;
        }

        if (this.countAttacks < 3) {
            monster.health -= this.getAttackPower();
            System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() + " for " + this.getAttackPower() + "  points of damage!");
            monster.isDead();
        } else {
            this.health -= this.getAttackPower();
            System.out.println(this.getName() + this.hashCode()  + " attacked itself in it's own confusion");
            System.out.println(this.getName() + this.hashCode()  + " has " + this.health + " health remaining.");
            this.health -= this.getAttackPower();
            this.countAttacks = 0;
            this.isDead();
            //if it attacks a third time in a row it will lose some health
        }
    }
}
