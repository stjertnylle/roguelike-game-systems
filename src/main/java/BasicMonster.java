public class BasicMonster extends Monster {

    // This class is only for testing the basic functionality that is shared by all monsters,
    // so the abstract methods have no implementation.

    public BasicMonster(int level) {
        super(level);
    }

    @Override
    void initializeAvailableActions() {

    }

    @Override
    void initializeWeapon() {

    }

    @Override
    void initializeElement() {

    }

    @Override
    Action getAction(double playerHealthRatio) {
        return null;
    }
}
