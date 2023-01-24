package Supernaturals.Strikeable.Monster;

import Supernaturals.Strikeable.Strikeable;
import Supernaturals.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
    public Monster(String name, int attackPower, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
        this.isDead = false;
    }

    public Monster() {
        super();
    }

    public abstract void monsterAttackObstacle(Supernatural obstacle);

    public boolean isDead() {
        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.getName() + " has been slain!!!");
            return true;
        } else {
            System.out.println(this.getName() + " has " + this.health + " health remaining.");
        }
        return false;
    }
}
