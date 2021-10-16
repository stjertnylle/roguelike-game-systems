public abstract class Player extends Entity {
    public Player(int level) {
        super(level);
    }

    abstract Action getAction();
}
