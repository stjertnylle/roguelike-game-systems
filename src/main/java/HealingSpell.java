public class HealingSpell implements Action {
    private final Entity user;
    private final String name = "Healing spell";
    private final int speed = 6;
    private final int manaCost;
    private final int healAmount;

    public HealingSpell(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 3;
        this.healAmount = level * 3;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getHealAmount() {
        return healAmount;
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
    public double getSpeed() {
        return speed;
    }
}
