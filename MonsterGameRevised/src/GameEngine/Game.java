package GameEngine;

import Supernaturals.Strikeable.Monster.MonsterType;
import Supernaturals.Strikeable.Monster.Mummy;
import Supernaturals.Strikeable.Monster.Vampire;
import Supernaturals.Strikeable.Monster.Werewolf;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    public static int roundCount;

    public int getRoundCount() {
        return roundCount;
    }

    public Game() {
        this.playerOne = new Player("Tiago", 5);
        this.playerTwo = new Player("Beatriz", 5);
        this.roundCount = 1;
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

    public Player firstPlayer;
    public Player secondPlayer;

    public void whoGoesFirst(Player p1, Player p2) {
        switch (Utilities.generateGuessingNumber(1, 2)) {
            case 1 -> {
                firstPlayer = p1;
                secondPlayer = p2;
            }
            case 2 -> {
                firstPlayer = p2;
                secondPlayer = p1;
            }
        }
    }

    public int MonsterSelector(Player player) {
        return Utilities.generateGuessingNumber(0, player.getMonstersAlive() - 1);
    }

    public void actualGame() {
        while (firstPlayer.getMonstersAlive() != 0 && secondPlayer.getMonstersAlive() != 0) {
            System.out.println("-------------------ROUND " + this.roundCount + "-----------------");

            System.out.println(firstPlayer.getPlayerName() + "'s turn!");
            int attackingMonster1 = MonsterSelector(firstPlayer);
            int defendingMonster1 = MonsterSelector(secondPlayer);
            firstPlayer.monsters[attackingMonster1].monsterAttack(secondPlayer.monsters[defendingMonster1]);
            if (secondPlayer.monsters[defendingMonster1].isDead) {
                secondPlayer.setMonstersAlive(secondPlayer.getMonstersAlive() - 1);
                secondPlayer.sortArray();
            }

            if(secondPlayer.getMonstersAlive() == 0){
                break;
            }

            System.out.println(secondPlayer.getPlayerName() + "'s turn!");
            int attackingMonster2 = MonsterSelector(secondPlayer);
            int defendingMonster2 = MonsterSelector(firstPlayer);
            secondPlayer.monsters[attackingMonster2].monsterAttack(firstPlayer.monsters[defendingMonster2]);
            if (firstPlayer.monsters[defendingMonster2].isDead) {
                firstPlayer.setMonstersAlive(firstPlayer.getMonstersAlive() - 1);
                firstPlayer.sortArray();
            }
            this.roundCount++;
        }
        printWinner();
    }
    public void printWinner() {
        if (firstPlayer.getMonstersAlive() == 0) {
            System.out.println(secondPlayer.getPlayerName() + " WINS!!!!!!!!!!!!");
        } else {
            System.out.println(firstPlayer.getPlayerName() + " WINS!!!!!!!!!!!!");
        }
    }
}

