import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Weapon> weaponInventory;
    private final Player owner;

    public Inventory(Player owner){
        this.weaponInventory = new ArrayList<Weapon>();
        this.owner = owner;
    }
    public int maxSize(){
        int maxSize = owner.getLevel().getCurrentLevel() + 5;
        return Math.min(maxSize, 30);
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
    public void removeWeapon(Weapon weapon){
        if(!(weaponInventory.contains(weapon))){
            throw new IllegalArgumentException("Inventory does not contain " + weapon.getWeaponName());
        }
        else{
            weaponInventory.remove(weapon);
        }
    }
    public boolean isFull(){
        return maxSize() == weaponInventory.size();
    }
    public Player getOwner(){
        return owner;
    }


    public ArrayList getWeapons(){
        if(weaponInventory.isEmpty()){
            return new ArrayList();
        }
        return weaponInventory;
    }

    public void clearInventory(){
        if(!weaponInventory.isEmpty())
            weaponInventory.clear();
    }
}
