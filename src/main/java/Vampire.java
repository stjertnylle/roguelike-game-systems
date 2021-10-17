import java.util.HashMap;

public class Vampire extends Monster {
    private Weapon weapon; // TODO: Add weapon
    private HashMap<String, Action> availableActions;

    public Vampire(int level) {
        super(level);
    }

    @Override
    public Element getElement() {
        return new Air();
    }

    @Override
    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(getLevel().getCurrentLevel()));
        availableActions.put("Heavy attack", new HeavyAttack(getLevel().getCurrentLevel()));
        availableActions.put("Healing spell", new HealingSpell(getLevel().getCurrentLevel()));
        availableActions.put("Life steal", new LifeSteal(getLevel().getCurrentLevel()));
        availableActions.put("Wind slash", new WindSlash(getLevel().getCurrentLevel()));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    Action getAction(double playerHealthRatio) {
        if (playerHealthRatio < 0.2) {
            if (getCurrentMana() >= ((WindSlash)availableActions.get("Wind slash")).getManaCost())
                return availableActions.get("Wind slash");
            else
                return availableActions.get("Light attack");
        }
        else if (getHealthRatio() < 0.2 && getCurrentMana() >= ((HealingSpell)availableActions.get("Healing spell")).getManaCost())
            return availableActions.get("Healing spell");
        else if (getHealthRatio() < 0.5 && getCurrentMana() >= ((LifeSteal)availableActions.get("Life steal")).getManaCost())
            return availableActions.get("Life steal");
        else
            return availableActions.get("Heavy attack");
    }

    @Override
    int getExpReward() {
        return getLevel().getCurrentLevel() * 10;
    }
}
