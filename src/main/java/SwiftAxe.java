public class SwiftAxe extends Weapon {
    private final double damageModifier = 1 ;
    private final double speedModifier = 1;

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
