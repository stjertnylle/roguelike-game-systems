public class SwiftAxe extends Weapon {
    private double damageModifier = 1 ;
    private double speedModifier = 1;

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
