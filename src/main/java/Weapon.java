public abstract class Weapon {
    private final String weaponName;

    public Weapon(String weaponName){
        this.weaponName = weaponName;
    }

    public abstract double getDamageModifier();

    public abstract double getSpeedModifier();

    public String getWeaponName() {
        return weaponName;
    }


}
