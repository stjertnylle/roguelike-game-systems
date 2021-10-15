public class HealingSpell implements Action {
    private final String name = "Healing spell";
    private final int speed = 6;
    private final int manaCost;
    private final int healAmount;

    public HealingSpell(int level) {
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
    public int getSpeed() {
        return speed;
    }
}
