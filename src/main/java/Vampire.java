import java.util.HashMap;

public class Vampire extends Monster {
    private Weapon weapon; // TODO: Add weapon
    private Element element; // TODO: Add element
    private HashMap<String, Action> availableActions;

    public Vampire(int level) {
        super(level);
    }

    @Override
    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(getLevel()));
        availableActions.put("Heavy attack", new HeavyAttack(getLevel()));
        availableActions.put("Healing spell", new HealingSpell(getLevel()));
        availableActions.put("Life steal", new LifeSteal(getLevel()));
        availableActions.put("Wind slash", new WindSlash(getLevel()));

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Element getElement() {
        return element;
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
}