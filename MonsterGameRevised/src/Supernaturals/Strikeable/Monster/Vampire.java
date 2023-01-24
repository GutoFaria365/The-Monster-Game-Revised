package Supernaturals.Strikeable.Monster;

import GameEngine.Utilities;
import Supernaturals.Fairy;
import Supernaturals.Supernatural;

public class Vampire extends Monster {
    public Vampire(String name, int attackPower, int health) {
        super(name, attackPower, health);

    }

    public Vampire(MonsterType monsterType) {
        this.setName(MonsterType.VAMPIRE.getName());
        this.setAttackPower(MonsterType.VAMPIRE.getAttackPower());
        this.setHealth(MonsterType.VAMPIRE.getHealth());
        this.setDead(false);
    }

    @Override
    public void monsterAttack(Monster monster) {
        monster.setHealth(monster.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " is attacking " + monster.getName() + " for " + this.getAttackPower() + "  points of damage!");

        //small chance of recovering health
        int healthBoost = Utilities.generateGuessingNumber(1, 10);
        if (healthBoost == 10) {
            System.out.println("Health Boost!!!");
            this.setHealth(this.getHealth() + 20);
        }
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
