public abstract class StandardPlayer extends Entity {
    public StandardPlayer(int level) {
        super(level);
    }

    abstract Action getAction();
}
