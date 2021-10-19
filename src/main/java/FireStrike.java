public class FireStrike implements Action {
    private final Entity user;
    private final String name = "Fire strike";
    private final int speed = 5;
    private final int manaCost;
    private final int damage;
    private final Element element = new Fire();

    public FireStrike(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 3;
        this.damage = level * 3;
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

    @Override
    public void apply(Entity target) {
        if(target == user){
            throw new IllegalArgumentException("Can't target self with spell");
        }else if(user.getCurrentMana() < getManaCost()){
            throw new IllegalStateException("Not enough mana");
        }
        target.decreaseHP((int) Math.floor(getDamage() * element.getModifierAgainst(target.getElement())));
        user.decreaseMana(getManaCost());
    }
}

