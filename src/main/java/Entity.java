public abstract class Entity {
    private int level;
    private int maxHP;
    private int currentHP;
    private int maxMana;
    private int currentMana;

    public Entity(int level) {
        if (level <= 0)
            throw new IllegalArgumentException("Level must be higher than 0!");
        this.level = level;
        initializeHP(level);
        initializeMana(level);
    }

    protected void initializeHP(int level) {
        this.maxHP = level * 10;
        this.currentHP = maxHP;
    }

    protected void initializeMana(int level) {
        this.maxMana = level * 10;
        this.currentMana = maxMana;
    }

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

    public double getHealthRatio() {
        double currentHP = this.currentHP;
        double maxHP = this.maxHP;
        return currentHP / maxHP;
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

}