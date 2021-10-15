public class LightAttack implements Action {
    private final int speed = 7;
    private final String name = "Light attack";
    private final int damage;

    public LightAttack(int level) {
        this.damage = level * 2;
    }

    public int getDamage() {
        return this.damage;
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
}
