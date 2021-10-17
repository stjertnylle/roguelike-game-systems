public class BasicEntity extends Entity {

    // This class is only for testing the basic functionality that is shared by all entities (Player and Monsters)

    public BasicEntity(int level) {
        super(level);
    }

    @Override
    public Weapon getWeapon() {
        return null;
    }

    @Override
    public Element getElement() {
        return null;
    }


}
