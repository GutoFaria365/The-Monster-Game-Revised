package Supernaturals.Strikeable;

import Supernaturals.Strikeable.Monster.Monster;
import Supernaturals.Supernatural;

public class Witch extends Supernatural implements Strikeable {

    public Witch() {
        this.name = "Witch";
        this.attackPower = 30;
        this.health = 150;
        this.isDead = false;
    }

    @Override
    public void monsterAttack(Monster monster) {

    }

    @Override
    public void obstacleAttack(Supernatural monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() + " for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
    }
}

