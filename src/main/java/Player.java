public class Player extends Entity {
    private Inventory playerInventory;

    public Player(int level) {
        super(level);
        this.playerInventory = new Inventory(this);
    }

    public void levelUP(){
        super.level++;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }
}
