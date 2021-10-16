import java.util.HashMap;

public class MonsterWithLowHPFastAttack extends Monster{
    private HashMap<String, Action> availableActions;

    public MonsterWithLowHPFastAttack(int level) {
        super(level);
    }

    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(getLevel()));
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Light attack");
    }
}
