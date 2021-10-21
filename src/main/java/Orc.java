import java.util.HashMap;

public class Orc extends Monster {
    private HashMap<String, Action> availableActions;

    public Orc(int level) {
        super(level);
        setWeapon(new DoubleAxe());
    }

    @Override
    public Element getElement() {
        return new Fire();
    }

    @Override
    protected void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(this));
        availableActions.put("Heavy attack", new HeavyAttack(this));
        availableActions.put("Fire strike", new FireStrike(this));
    }

    @Override
    protected Action getAction(double playerHealthRatio) {
        if (playerHealthRatio > 1 || playerHealthRatio <= 0)
            throw new IllegalArgumentException("Player health ratio must be within range 0 < x >= 1");
        else if (playerHealthRatio < 0.2)
            return availableActions.get("Light attack");
        else if (getCurrentMana() >= ((FireStrike)availableActions.get("Fire strike")).getManaCost())
            return availableActions.get("Fire strike");
        else
            return availableActions.get("Heavy attack");

    }

    @Override
    protected int getExpReward() {
        return getLevel().getCurrentLevel() * 5;
    }
}
