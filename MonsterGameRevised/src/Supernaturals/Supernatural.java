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

    public String getName() {
        return name;
    }

    public boolean isDead() {
        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.getName() + " has been slain!!!");
            return true;
        } else if (this instanceof Fairy) {
            this.isDead = true;
        } else {
            System.out.println(this.getName() + " has " + this.health + " health remaining.");
        }
        return false;
    }

    public abstract void obstacleAttack(Supernatural monster);
}

