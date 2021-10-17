import java.util.HashMap;

public class Orc extends Monster {
    private Weapon weapon; // TODO: Add weapon
    private HashMap<String, Action> availableActions;

    public Orc(int level) {
        super(level);
    }

    @Override
    public Element getElement() {
        return new Fire();
    }

    @Override
    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(getLevel().getCurrentLevel()));
        availableActions.put("Heavy attack", new HeavyAttack(getLevel().getCurrentLevel()));
        availableActions.put("Fire strike", new FireStrike(getLevel().getCurrentLevel()));
    }

    @Override
    Action getAction(double playerHealthRatio) {
        if (playerHealthRatio < 0.2)
            return availableActions.get("Light attack");
        else if (getCurrentMana() >= ((FireStrike)availableActions.get("Fire strike")).getManaCost())
            return availableActions.get("Fire strike");
        else
            return availableActions.get("Heavy attack");

    }

    @Override
    int getExpReward() {
        return getLevel().getCurrentLevel() * 5;
    }
}
