package Supernaturals.Strikeable;

import Supernaturals.Strikeable.Monster.Monster;
import Supernaturals.Supernatural;

public class Witch extends Supernatural implements Strikeable {

    public Witch() {
        this.setName("Witch");
        this.setAttackPower(30);
        this.setHealth(150);
        this.setDead(false);
    }

    @Override
    public void monsterAttack(Monster monster) {

    }

    @Override
    public void obstacleAttack(Supernatural monster) {
        monster.setHealth(monster.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " is attacking " + monster.getName() + " for " + this.getAttackPower() + "  points of damage!");
        monster.checkIfDead();
    }
}

