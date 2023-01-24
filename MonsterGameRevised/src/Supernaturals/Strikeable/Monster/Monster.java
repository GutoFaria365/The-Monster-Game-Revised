package Supernaturals.Strikeable.Monster;

import Supernaturals.Strikeable.Strikeable;
import Supernaturals.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
    public Monster(String name, int attackPower, int health) {
        this.setName(name);
        this.setAttackPower(attackPower);
        this.setHealth(health);
        this.setDead(false);
    }

    public Monster() {
        super();
    }

    public abstract void monsterAttackObstacle(Supernatural obstacle);

    public boolean checkIfDead() {
        if (this.getHealth() <= 0) {
            this.setDead(true);
            System.out.println(this.getName() + " has been slain!!!");
            return true;
        } else {
            System.out.println(this.getName() + " has " + this.getHealth() + " health remaining.");
        }
        return false;
    }
}
