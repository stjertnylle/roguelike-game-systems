public class LightAttack implements Action {
    private final Entity user;
    private final int speed = 7;
    private final String name = "Light attack";
    private final int damage;

    public LightAttack(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.damage = level * 2;
    }

    public int getDamage() {
        return this.damage;
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
    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        return speed * user.getWeapon().getSpeedModifier();
    }
}
