package Supernaturals.Strikeable;
import Supernaturals.Strikeable.Monster.Monster;
import Supernaturals.Supernatural;

public class Witch extends Supernatural implements Strikeable {

    @Override
    public void monsterAttack(Monster monster) {
        monster.health -= this.getAttackPower();
        System.out.println(this.getName() + this.hashCode() + " is attacking " + monster.getName() + monster.hashCode() +" for " + this.getAttackPower() + "  points of damage!");
        monster.isDead();
    }
}

