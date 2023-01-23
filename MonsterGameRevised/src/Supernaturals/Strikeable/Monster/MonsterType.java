package Supernaturals.Strikeable.Monster;

public enum MonsterType {
    MUMMY ("Mummy", 30, 80, false),
    VAMPIRE ("Vampire", 20, 100, false),
    WEREWOLF ("Werewolf", 20, 120, false);

    private String name;
    private int attackPower;
    private int health;
    private boolean isDead;

    MonsterType(String name, int attackPower, int health, boolean isDead) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }
}

