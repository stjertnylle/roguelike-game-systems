import java.util.HashMap;

public class MonsterWithLowHPFastAttack extends Monster{
    private HashMap<String, Action> availableActions;
    private final Weapon weapon = new NoModifierWeapon();

    public MonsterWithLowHPFastAttack(int level) {
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
        availableActions.put("Light attack", new LightAttack(this));
    }

    @Override
    int getExpReward(){
        return 0;
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Light attack");
    }


}
