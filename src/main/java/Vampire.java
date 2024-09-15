import java.util.HashMap;

public class Vampire extends Monster {
    private HashMap<String, Action> availableActions;

    public Vampire(int level) {
        super(level);
        setWeapon(new SwiftAxe());
    }

    @Override
    public Element getElement() {
        return new Air();
    }

    @Override
    protected void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(this));
        availableActions.put("Heavy attack", new HeavyAttack(this));
        availableActions.put("Healing spell", new HealingSpell(this));
        availableActions.put("Life steal", new LifeSteal(this));
        availableActions.put("Wind slash", new WindSlash(this));
    }

    @Override
    protected Action getAction(double playerHealthRatio) {
        if (playerHealthRatio > 1 || playerHealthRatio <= 0)
            throw new IllegalArgumentException("Player health ratio must be within range 0 < x >= 1");
        else if (playerHealthRatio < 0.2) {
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
    protected int getExpReward() {
        return getLevel().getCurrentLevel() * 10;
    }
}
