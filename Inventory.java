import java.util.ArrayList;

public class Inventory {
    private ArrayList<Weapon> weaponInventory;
    private Player owner;

    public Inventory(Player owner){
        this.weaponInventory = new ArrayList<Weapon>();
        this.owner = owner;
    }
    public int maxSize(){
        int maxSize = owner.getLevel() + 5;
        if (maxSize > 30){
            return 30;
        }
        return maxSize;
    }
    public void addWeapon(Weapon weaponToAdd){
        if (isFull()){
            throw new IllegalStateException("Inventory full, cannot add " + weaponToAdd.getWeaponName());
        }
        else if(weaponInventory.contains(weaponToAdd)){
            throw new IllegalStateException("Inventory already contains " + weaponToAdd.getWeaponName());
        }
        weaponInventory.add(weaponToAdd);
    }
    public boolean isFull(){
        return maxSize() == weaponInventory.size();
    }
    public Player getOwner(){
        return owner;
    }
    public ArrayList getWeapons(){
        return null;
    }
}
