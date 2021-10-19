
public abstract class Player extends Entity {
    private final Inventory playerInventory;
    private final PotionInventory potionInventory;

    public Player(int level){
        super(level);
        this.playerInventory = new Inventory(this);
        this.potionInventory = new PotionInventory();
    }

    public void increaseXP(int xp){
        int oldLevel = this.getLevel().getCurrentLevel();
        this.getLevel().addXP(xp);
        int newLevel = this.getLevel().getCurrentLevel();
        if(newLevel > oldLevel){
        initializeHP(this.getLevel().getCurrentLevel());
        initializeMana(this.getLevel().getCurrentLevel());}
    }

    public void equipWeapon(Weapon weapon){
        Weapon previousWeapon = this.getWeapon();
        super.setWeapon(weapon);
        if ( playerInventory.getWeapons().contains(weapon) ) {
            playerInventory.removeWeapon(weapon);
        }
        if ( playerInventory.isFull() ) {
            return;
        }
        playerInventory.addWeapon(previousWeapon);
    }

    public Inventory getPlayerInventory(){
        return playerInventory;
    }

    public PotionInventory getPotionInventory(){
        return potionInventory;
    }

    abstract Action getAction();
}
