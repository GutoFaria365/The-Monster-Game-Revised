package Supernaturals.Strikeable.Monster;

import Supernaturals.Fairy;
import Supernaturals.Supernatural;

public class Mummy extends Monster {
    public int countAttacks = 0;
    public int previousRound = 0;

    public Mummy(String name, int attackPower, int health) {
        super(name, attackPower, health);

    }

    public Mummy(MonsterType monsterType) {
        this.name = MonsterType.MUMMY.getName();
        this.attackPower = MonsterType.MUMMY.getAttackPower();
        this.health = MonsterType.MUMMY.getHealth();
        this.isDead = false;
    }

    @Override
    public void monsterAttack(Monster monster, int gameRound) {
        if (this.previousRound == 0 || gameRound - this.previousRound == 2) {
            this.previousRound = gameRound;
            this.countAttacks++;
            if (this.countAttacks >= 3) {
                this.health -= this.getAttackPower();
                System.out.println(this.getName() + " attacked itself in it's own confusion");
                System.out.println(this.getName() + " has " + this.health + " health remaining.");
                this.health -= this.getAttackPower();
                this.countAttacks = 0;
                this.isDead();
                return;
                //if it attacks a third time in a row it will lose some health
            }
        } else {
            System.out.println(this.countAttacks + "a" + "round4a" + gameRound);
            this.countAttacks = 0;
            this.previousRound = 0;
        }

        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + " is attacking " + monster.getName() + " for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
    }

    @Override
    public void monsterAttackObstacle(Supernatural obstacle) {
        if (obstacle instanceof Fairy) {
            System.out.println("Really? You tried attacking a fairy?? tsk tsk tsk...");
        } else {
            obstacle.health -= this.getAttackPower() / 2;
            System.out.println(this.getName() + " is attacking " + obstacle.getName() + " for " + this.getAttackPower() + "  points of damage!");
            obstacle.isDead();
        }
    }

    @Override
    public void obstacleAttack(Supernatural monster) {

    }
}
