public class SwiftAxe extends Weapon {
    private final double damageModifier = 0.5 ;
    private final double speedModifier = 1.5;

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
