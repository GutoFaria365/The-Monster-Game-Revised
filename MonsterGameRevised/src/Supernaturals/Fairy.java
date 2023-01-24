package Supernaturals;

public class Fairy extends Supernatural {
    public Fairy() {
        super();
        this.setName("Fairy");
        this.setAttackPower(10);
        this.setHealth(1000);
        this.setDead(false);
    }

    @Override
    public void obstacleAttack(Supernatural monster) {
        monster.setHealth(monster.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " is attacking " + monster.getName() + " for " + this.getAttackPower() + "  points of damage!");
        monster.checkIfDead();
        this.checkIfDead();
    }

}

