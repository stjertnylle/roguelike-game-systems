public class HeavyAttack implements Action {
    private final Entity user;
    private final int speed = 5;
    private final int damage;

    public HeavyAttack(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.damage = level * 3;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void apply(Entity target) {
        if(user.getWeapon() == null){
            throw new IllegalStateException("Can't attack without weapon equipped");
        }else if(target == user){
            throw new IllegalArgumentException("Can't target self with attack");
        }
        target.decreaseHP((int) Math.floor(getDamage() * user.getWeapon().getDamageModifier()));
    }

    @Override
    public double getSpeed() {
        return speed * user.getWeapon().getSpeedModifier();
    }
}
