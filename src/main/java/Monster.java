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
    public int getExpReward() {
        return getLevel() * 10;
    }

}
