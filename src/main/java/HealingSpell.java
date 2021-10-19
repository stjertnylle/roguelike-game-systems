public class HealingSpell implements Action {
    private final Entity user;
    private final String name = "Healing spell";
    private final int speed = 6;
    private final int manaCost;
    private final int healAmount;

    public HealingSpell(Entity user) {
        this.user = user;
        int level = user.getLevel().getCurrentLevel();
        this.manaCost = level * 3;
        this.healAmount = level * 3;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void apply(Entity target) {
        if(target != user){
            throw new IllegalArgumentException("Can't target monster with spell");
        }else if(user.getCurrentMana() < getManaCost()){
            throw new IllegalStateException("Not enough mana");
        }
        target.increaseHP(getHealAmount());
        user.decreaseMana(getManaCost());
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
