public class LightAttack implements Action {
    private final Entity user;
    private final int speed = 7;
    private final String name = "Light attack";
    private final int damage;

    public LightAttack(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.damage = level * 2;
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public void use(Entity user, Entity receiver) {
        // TODO: Implement!
        receiver.decreaseHP(this.damage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        return speed * user.getWeapon().getSpeedModifier();
    }
}
