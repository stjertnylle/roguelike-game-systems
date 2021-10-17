
public abstract class Player extends Entity {
    private Inventory playerInventory;

    public Player(int level){
        super(level);
        this.playerInventory = new Inventory(this);
    }

    public void increaseXP(int xp){
        this.getLevel().addXP(xp);
    };


    public Inventory getPlayerInventory(){
        return playerInventory;
    }

    abstract Action getAction();
}
