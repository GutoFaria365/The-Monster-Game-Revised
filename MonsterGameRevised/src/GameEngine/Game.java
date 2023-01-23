package GameEngine;

import Supernaturals.Strikeable.Monster.MonsterType;
import Supernaturals.Strikeable.Monster.Mummy;
import Supernaturals.Strikeable.Monster.Vampire;
import Supernaturals.Strikeable.Monster.Werewolf;

public class Game {
    public static int roundCount;
    public Player attacker;
    public Player defender;
    private Player playerOne;
    private Player playerTwo;

    public Game() {
        this.playerOne = new Player("Tiago", 5);
        this.playerTwo = new Player("Beatriz", 5);
        this.roundCount = 1;
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
                case 1 -> player.monsters[i] = new Werewolf(MonsterType.WEREWOLF);
                case 2 -> player.monsters[i] = new Vampire(MonsterType.VAMPIRE);
                case 3 -> player.monsters[i] = new Mummy(MonsterType.MUMMY);
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

    public void actualGame() {


        while (attacker.getMonstersAlive() != 0 && defender.getMonstersAlive() != 0) {
            //chance to generate obstacle
            if (generateObstacle() == true) {

            } else {
                Player tempAttacker;
                System.out.println("-------------------TURN " + this.roundCount + "-----------------");
                System.out.println(attacker.getPlayerName() + "'s turn!");
                int attackingMonster1 = MonsterSelector(attacker);
                int defendingMonster1 = MonsterSelector(defender);
                attacker.monsters[attackingMonster1].monsterAttack(defender.monsters[defendingMonster1]);
                if (defender.monsters[defendingMonster1].isDead) {
                    defender.setMonstersAlive(defender.getMonstersAlive() - 1);
                    defender.sortArray();
                }
                tempAttacker = attacker;
                attacker = defender;
                defender = tempAttacker;
                this.roundCount++;
            }
        }
        printWinner();
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
            System.out.println("TIME FOR THE BOSS BATTLE");
            this.roundCount++;
            return true;
        }
        return false;
    }
}

