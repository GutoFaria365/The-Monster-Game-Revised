package GameEngine;

import Supernaturals.Fairy;
import Supernaturals.Strikeable.Monster.*;
import Supernaturals.Strikeable.Witch;
import Supernaturals.Supernatural;

public class Game {
    public static int roundCount;
    public Player attacker;
    public Player defender;
    public Supernatural[] obstacles;
    private Player playerOne;
    private Player playerTwo;

    public Game() {
        this.playerOne = new Player("Tiago", 5);
        this.playerTwo = new Player("Beatriz", 5);
        this.roundCount = 1;
        this.obstacles = new Supernatural[3];
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void gameStart() {
        if (this.playerOne.getNumberOfMonsters() == this.playerTwo.getNumberOfMonsters()) {
            System.out.println("Welcome " + this.playerOne.getPlayerName() + " and " + this.playerTwo.getPlayerName() + "!");
            System.out.println("The game will start with " + this.playerOne.getNumberOfMonsters() + " monsters!!!");
            randomMonster(this.playerOne);
            randomMonster(this.playerTwo);
            whoGoesFirst(this.playerOne, this.playerTwo);
            actualGame();
        } else {
            System.out.println("The number of monsters selected doesn't match, select the same value for both players!!");
        }
    }

    public void randomMonster(Player player) {
        for (int i = 0; i < player.getNumberOfMonsters(); i++) {
            switch (Utilities.generateGuessingNumber()) {
                case 1 -> player.getMonsters()[i] = new Werewolf(MonsterType.WEREWOLF);
                case 2 -> player.getMonsters()[i] = new Vampire(MonsterType.VAMPIRE);
                case 3 -> player.getMonsters()[i] = new Mummy(MonsterType.MUMMY);
            }
        }
    }

    public void whoGoesFirst(Player p1, Player p2) {
        switch (Utilities.generateGuessingNumber(1, 2)) {
            case 1 -> {
                attacker = p1;
                defender = p2;
            }
            case 2 -> {
                attacker = p2;
                defender = p1;
            }
        }
    }

    public int MonsterSelector(Player player) {
        return Utilities.generateGuessingNumber(0, player.getMonstersAlive() - 1);
    }

    public Monster MonsterSelector2(Player player) {
        int index = Utilities.generateGuessingNumber(0, player.getMonstersAlive() - 1);
        return player.getMonsters()[index];
    }

    public void actualGame() {
        while (attacker.getMonstersAlive() != 0 && defender.getMonstersAlive() != 0) {
            //chance to generate obstacle
            if (generateObstacle()) {
                obstacleFight();
            } else {
                monsterVsMonster();
            }
        }
        printWinner();
    }

    private void monsterVsMonster() {
        System.out.println("-------------------TURN " + this.roundCount + "-----------------");
        System.out.println(attacker.getPlayerName() + "'s turn! " + attacker.getMonstersAlive() + " monsters remaining");
        Monster attackingMonster = MonsterSelector2(attacker);
        Monster defendingMonster = MonsterSelector2(defender);
        attackingMonster.monsterAttack(defendingMonster);
        if (defendingMonster.isDead) {
            defender.setMonstersAlive(defender.getMonstersAlive() - 1);
            defender.sortArray();
        }
        attackerSwitch();
    }

    private void obstacleFight() {
        Monster defendingMonsterFromObs = MonsterSelector2(attacker);
        Monster attackingMonsterAgainstObs = MonsterSelector2(attacker);

        System.out.println("TIME FOR THE BOSS BATTLE");
        switch (Utilities.generateGuessingNumber(1, 2)) {
            case 1 -> obstacles[0] = new Witch();
            case 2 -> obstacles[0] = new Fairy();
        }
        while (!obstacles[0].isDead && attacker.getMonstersAlive() != 0 && defender.getMonstersAlive() != 0) {
            obstacles[0].obstacleAttack(defendingMonsterFromObs);
            if (defendingMonsterFromObs.isDead) {
                attacker.setMonstersAlive(attacker.getMonstersAlive() - 1);
                attacker.sortArray();
            }
            attackingMonsterAgainstObs.monsterAttackObstacle(obstacles[0]);
            attackerSwitch();
        }
    }

    private void attackerSwitch() {
        Player tempAttacker;
        tempAttacker = attacker;
        attacker = defender;
        defender = tempAttacker;
        this.roundCount++;
    }

    public void printWinner() {
        if (attacker.getMonstersAlive() == 0) {
            System.out.println(defender.getPlayerName() + " WINS!!!!!!!!!!!!");
        } else {
            System.out.println(attacker.getPlayerName() + " WINS!!!!!!!!!!!!");
        }
    }

    public boolean generateObstacle() {
        int obstacleChance = Utilities.generateGuessingNumber(1, 10);
        if (obstacleChance == 10) {
            return true;
        }
        return false;
    }


}

