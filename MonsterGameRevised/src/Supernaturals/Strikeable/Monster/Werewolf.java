package Supernaturals.Strikeable.Monster;

import Supernaturals.Fairy;
import Supernaturals.Supernatural;

public class Werewolf extends Monster {
    public Werewolf(String name, int attackPower, int health) {
        super(name, attackPower, health);
        //no special
    }


    public Werewolf(MonsterType monsterType) {
        this.setName(MonsterType.WEREWOLF.getName());
        this.setAttackPower(MonsterType.WEREWOLF.getAttackPower());
        this.setHealth(MonsterType.WEREWOLF.getHealth());
        this.setDead(false);
    }

    @Override
    public void monsterAttack(Monster monster) {
        monster.setHealth(monster.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " is attacking " + monster.getName() + " for " + this.getAttackPower() + "  points of damage!");
        monster.checkIfDead();
    }

    @Override
    public void monsterAttackObstacle(Supernatural obstacle) {
        if (obstacle instanceof Fairy) {
            System.out.println("Really? You tried attacking a fairy?? tsk tsk tsk...");
        } else {
            obstacle.setHealth(obstacle.getHealth() - this.getAttackPower() / 2);
            System.out.println(this.getName() + " is attacking " + obstacle.getName() + " for " + this.getAttackPower() + "  points of damage!");
            obstacle.checkIfDead();
        }
    }

    @Override
    public void obstacleAttack(Supernatural monster) {

    }
}
