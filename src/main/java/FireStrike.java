public class FireStrike implements Action {
    private final Entity user;
    private final String name = "Fire strike";
    private final int speed = 5;
    private final int manaCost;
    private final int damage;
    private final Element element = new Fire();

    public FireStrike(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 3;
        this.damage = level * 3;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        return speed * user.getWeapon().getSpeedModifier();
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void use(Entity user, Entity receiver) {

    }
}
