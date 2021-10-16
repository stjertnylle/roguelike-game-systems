import java.util.HashMap;

public class MonsterWithLowHPSlowAttack extends Monster{
    private HashMap<String, Action> availableActions;

    public MonsterWithLowHPSlowAttack(int level) {
        super(level);
    }

    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Heavy attack", new HeavyAttack(getLevel()));
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Heavy attack");
    }
}
