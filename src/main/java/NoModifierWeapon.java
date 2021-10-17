public class NoModifierWeapon extends Weapon {
    private double damageModifier = 1;
    private double speedModifier = 1;

    public NoModifierWeapon() {
        super("No Modifier Weapon");
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
