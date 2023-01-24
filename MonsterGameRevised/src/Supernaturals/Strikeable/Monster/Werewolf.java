package Supernaturals.Strikeable.Monster;

import Supernaturals.Fairy;
import Supernaturals.Supernatural;

public class Werewolf extends Monster {
    public Werewolf(String name, int attackPower, int health) {
        super(name, attackPower, health);
        //no special
    }

    public Werewolf() {
        this.name = "Werewolf";
        this.attackPower = 20;
        this.health = 120;
        this.isDead = false;

    }

    public Werewolf(MonsterType monsterType) {
        this.name = MonsterType.WEREWOLF.getName();
        this.attackPower = MonsterType.WEREWOLF.getAttackPower();
        this.health = MonsterType.WEREWOLF.getHealth();
        this.isDead = false;
    }

    @Override
    public void monsterAttack(Monster monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() + " for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
    }

    @Override
    public void monsterAttackObstacle(Supernatural obstacle) {
        if (obstacle instanceof Fairy) {
            System.out.println("Really? You tried attacking a fairy?? tsk tsk tsk...");
        } else {
            obstacle.health -= this.getAttackPower();
            System.out.println(this.getName() + this.hashCode() + " is attacking " + obstacle.getName() + obstacle.hashCode() + " for " + this.getAttackPower() + "  points of damage!");
            obstacle.isDead();
        }
    }

    @Override
    public void obstacleAttack(Supernatural monster) {

    }
}
