package Supernaturals.Strikeable;

import Supernaturals.Strikeable.Monster.Monster;

public interface Strikeable {
    default public void monsterAttack(Monster monster) {
    }

    ;

    default public void monsterAttack(Monster monster, int gameRound) {
    }

    ;


}
