public class HeavyAttack implements Action {
    private final int speed = 5;
    private final String name = "Heavy attack";
    private final int damage;

    public HeavyAttack(int level) {
        this.damage = level * 3;
    }

    public int getDamage() {
        return damage;
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
