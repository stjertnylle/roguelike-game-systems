public class DoubleAxe extends Weapon{
    private double damageModifier = 1.7;
    private double speedModifier = 0.3;

    public DoubleAxe() {
        super("Double Axe");
    }

    @Override
    public double getDamageModifier() { return damageModifier; }

    @Override
    public double getSpeedModifier() { return speedModifier; }
}
