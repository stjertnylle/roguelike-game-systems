public class WindSlash implements Action {
    private final String name = "Wind slash";
    private final int speed = 8;
    private final int manaCost;
    private final int damage;

    public WindSlash(int level) {
        this.manaCost = level * 2;
        this.damage = level * 2;
    }

    @Override
    public void use(Entity user, Entity receiver) {
        // TODO: Implement!
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }
}
