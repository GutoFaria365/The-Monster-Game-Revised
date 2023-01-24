package Supernaturals;

public abstract class Supernatural {

    private boolean isDead;
    private String name;
    private int attackPower;
    private int health;

    public Supernatural() {
        this.setAttackPower(30);
        this.setHealth(100);
        this.setDead(false);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkIfDead() {
        if (this.getHealth() <= 0) {
            this.setDead(true);
            System.out.println(this.getName() + " has been slain!!!");
            return true;
        } else if (this instanceof Fairy) {
            this.setDead(true);
        } else {
            System.out.println(this.getName() + " has " + this.getHealth() + " health remaining.");
        }
        return false;
    }

    public abstract void obstacleAttack(Supernatural monster);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}

