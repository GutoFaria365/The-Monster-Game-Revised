package Supernaturals;

public abstract class Supernatural {

    public String name;
    public int attackPower;
    public int health;
    public boolean isDead;

public Supernatural (){
    this.attackPower = 30;
    this.health = 100;
    this.isDead = false;
}

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
