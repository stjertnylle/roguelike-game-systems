public class LifeSteal implements Action {
    private final String name = "Life steal";
    private final int speed = 4;
    private final int manaCost;
    private final int damage;

    public LifeSteal(int level) {
        this.manaCost = level * 2;
        this.damage = level;
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
