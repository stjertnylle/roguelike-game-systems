public class SwiftAxe extends Weapon {
    private double damageModifier = 0.5;
    private double speedModifier = 1.5;

    public SwiftAxe() {
        super("Swift Axe");
    }

    @Override
    public double getDamageModifier() {
        return damageModifier;
    }

    @Override
    public double getSpeedModifier() {
        return speedModifier;
    }

}
