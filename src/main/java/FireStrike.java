public class FireStrike implements Action {
    private final String name = "Fire strike";
    private final int speed = 5;
    private final int manaCost;
    private final int damage;
    private final Element element = new Fire();

    public FireStrike(int level) {
        this.manaCost = level * 3;
        this.damage = level * 3;
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

    @Override
    public void use(Entity user, Entity receiver) {

    }
}
