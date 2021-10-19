public class WindSlash implements Action {
    private final Entity user;
    private final String name = "Wind slash";
    private final int speed = 8;
    private final int manaCost;
    private final int damage;
    private final Element element = new Air();

    public WindSlash(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 2;
        this.damage = level * 2;
    }

    @Override
    public void apply(Entity target) {
        if(target == user){
            throw new IllegalArgumentException("Can't target self with spell");
        }else if(user.getCurrentMana() < getManaCost()){
            throw new IllegalStateException("Not enough mana");
        }
        target.decreaseHP((int) (getDamage() * element.getModifierAgainst(target.getElement())));
        user.decreaseMana(getManaCost());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        return speed * user.getWeapon().getSpeedModifier();
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }
}
