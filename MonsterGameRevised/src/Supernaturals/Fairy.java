package Supernaturals;

public class Fairy extends Supernatural {
    public Fairy() {
        super();
        this.name = "Fairy";
        this.attackPower = 10;
        this.health = 1000;
        this.isDead = false;
        this.untouchable = true;
    }

    @Override
    public void obstacleAttack(Supernatural monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() + " for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
        this.isDead();
    }

}

