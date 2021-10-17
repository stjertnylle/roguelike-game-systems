import java.util.HashMap;

public class MonsterWithLowHPSlowAttack extends Monster{
    private HashMap<String, Action> availableActions;
    private final Weapon weapon = new NoModifierWeapon();

    public MonsterWithLowHPSlowAttack(int level) {
        super(level);
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public Element getElement(){
        return null;
    }

    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Heavy attack", new HeavyAttack(this));
    }

    @Override
    int getExpReward(){
        return 160;
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Heavy attack");
    }
}
