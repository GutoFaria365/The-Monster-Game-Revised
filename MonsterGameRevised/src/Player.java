public class Player {
    private String playerName;
    private int numberOfMonsters;
    private int monstersAlive;
    public Monster[] monsters;




    public Player(String name, int numberOfMonsters) {
        this.playerName = name;
        this.numberOfMonsters = numberOfMonsters;
        this.monsters = new Monster[numberOfMonsters];
        this.monstersAlive = numberOfMonsters;
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setNumberOfMonsters(int numberOfMonsters) {
        this.numberOfMonsters = numberOfMonsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = new Monster[numberOfMonsters];
    }

    public Monster[] sortArray (){
        if (this.monsters == null){
            return null;
        }
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].isDead == true){
                for (int j = i+1; j < monsters.length; j++) {
                    if(monsters[j].isDead == false){
                        Monster temp = monsters[j];
                        monsters[j] = monsters[i];
                        monsters[i] = temp;
                        break;
                        //names[j] = null;
                    } else if (monsters[j].isDead == true) {
                        continue;
                    }

                }
            }
        }return monsters;
    }
}
