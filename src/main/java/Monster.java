import java.util.ArrayList;

public abstract class Monster {

    // Instance variables
    private int level;
    private int maxHP;
    private int currentHP;
    private int maxMana;
    private int currentMana;

    // Constructor
    public Monster(int level) {
        if (level < 0)
            throw new IllegalArgumentException("Level can not be negative!");
        this.level = level;
        this.maxHP = level * 10;
        this.currentHP = maxHP;
        this.maxMana = level * 10;
        this.currentMana = maxMana;
        initializeAvailableActions();
        initializeWeapon();
        initializeElement();
    }

    // Abstract methods, each monster type will have its own implementation
    abstract void initializeAvailableActions();
    abstract void initializeWeapon();
    abstract void initializeElement();
    abstract Action getAction();

    // Methods with implementation shared by all monsters
    public int getLevel() {
        return level;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setHP(int value) {
        currentHP = value;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void increaseHP(int amount) {
        currentHP = Math.min(currentHP + amount, maxHP);
    }

    public void decreaseHP(int amount) {
        currentHP -= amount;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setMana(int value) {
        currentMana = value;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void increaseMana(int amount) {
        currentMana = Math.min(currentMana + amount, maxMana);
    }

    public void decreaseMana(int amount) {
        currentMana = Math.max(currentMana - amount, 0);
    }

    public int getExpReward() {
        return level * 10;
    }


}
