public abstract class Monster extends Entity {

    // Constructor
    public Monster(int level) {
        super(level);
        initializeAvailableActions();
    }

    // Abstract methods, each monster type will have its own behaviour
    abstract void initializeAvailableActions();
    abstract int getExpReward();
    abstract Action getAction(double playerHealthRatio);
}
