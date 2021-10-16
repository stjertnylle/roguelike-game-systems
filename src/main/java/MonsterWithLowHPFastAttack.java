import java.util.HashMap;

public class MonsterWithLowHPFastAttack extends Monster{
    private HashMap<String, Action> availableActions;

    public MonsterWithLowHPFastAttack(int level) {
        super(level);
    }

    @Override
    public Element getElement(){
        return null;
    }

    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Light attack", new LightAttack(getLevel()));
    }

    @Override
    int getExpReward(){
        return 0;
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Light attack");
    }


}
