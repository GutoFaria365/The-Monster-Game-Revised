package Supernaturals;

public abstract class Supernatural {

    public String name;
    public int attackPower;
    public int health;
    public boolean isDead;
    public boolean untouchable;

    public Supernatural() {
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

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return isDead;
    }

    public abstract void obstacleAttack(Supernatural monster);
}
