public abstract class Monster extends Entity {

    // Constructor
    public Monster(int level) {
        super(level);
        initializeAvailableActions();
    }

    // Abstract methods, each monster type will have its own behaviour
    protected abstract void initializeAvailableActions();
    protected abstract int getExpReward();
    protected abstract Action getAction(double playerHealthRatio);
}
