public abstract class Monster extends Entity {

    // Constructor
    public Monster(int level) {
        super(level);
        initializeAvailableActions();
    }

    // Abstract methods, each monster type will have its own behaviour
    abstract void initializeAvailableActions();
    abstract Action getAction(double playerHealthRatio);

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

    public double getHealthRatio() {
        double currentHP = this.currentHP;
        double maxHP = this.maxHP;
        return currentHP / maxHP;
    }

    public void increaseHP(int amount) {currentHP = Math.min(currentHP + amount, maxHP);}

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
        return getLevel() * 10;
    }

}
