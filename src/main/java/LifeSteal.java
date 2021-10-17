public class LifeSteal implements Action {
    private final Entity user;
    private final String name = "Life steal";
    private final int speed = 4;
    private final int manaCost;
    private final int damage;

    public LifeSteal(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 2;
        this.damage = level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void apply(Entity target) {
        target.decreaseHP(getDamage());
        user.increaseHP(getDamage());
        user.decreaseMana(getManaCost());
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }
}
