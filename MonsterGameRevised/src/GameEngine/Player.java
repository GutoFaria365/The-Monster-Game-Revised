package GameEngine;

import Supernaturals.Strikeable.Monster.Monster;

public class Player {
    private String playerName;
    private int numberOfMonsters;
    private int monstersAlive;
    private Monster[] monsters;


    public Player(String name, int numberOfMonsters) {
        this.playerName = name;
        this.numberOfMonsters = numberOfMonsters;
        this.setMonsters(new Monster[numberOfMonsters]);
        this.monstersAlive = numberOfMonsters;
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public void setNumberOfMonsters(int numberOfMonsters) {
        this.numberOfMonsters = numberOfMonsters;
    }

    public int getMonstersAlive() {
        return monstersAlive;
    }

    public void setMonstersAlive(int monstersAlive) {
        this.monstersAlive = monstersAlive;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = new Monster[numberOfMonsters];
    }

    public String getPlayerName() {
        return playerName;
    }

    public Monster[] sortArray() {
        if (this.getMonsters() == null) {
            return null;
        }
        for (int i = 0; i < getMonsters().length; i++) {
            if (getMonsters()[i].isDead == true) {
                for (int j = i + 1; j < getMonsters().length; j++) {
                    if (getMonsters()[j].isDead == false) {
                        Monster temp = getMonsters()[j];
                        getMonsters()[j] = getMonsters()[i];
                        getMonsters()[i] = temp;
                        break;
                        //names[j] = null;
                    } else if (getMonsters()[j].isDead == true) {
                        continue;
                    }

                }
            }
        }
        return getMonsters();
    }
}
