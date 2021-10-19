import java.util.HashMap;
import java.util.NoSuchElementException;

public class PotionInventory {
    private final HashMap<Potion, Integer> potionBag;

    public PotionInventory(){
        this.potionBag = new HashMap<>();
    }


    public void add(Potion potion){
        if ( !potionBag.containsKey(potion) ) {
            potionBag.put(potion,1);
        } else {
            potionBag.put(potion,potionBag.get(potion) + 1);
        }
    }

    public boolean contains(Potion potion){
        return potionBag.containsKey(potion);
    }

    public int count(Potion potion){
        return potionBag.getOrDefault(potion,0);
    }

    public void remove(Potion potion) throws NoSuchElementException{

        if ( this.count(potion) == 1 ) {
            potionBag.remove(potion);
        } else if ( this.count(potion) > 1 ) {
            potionBag.put(potion,potionBag.get(potion) - 1);
        } else {
            throw new NoSuchElementException("There is no such potion to remove");
        }


    }



    public void clearPotionInventory(){
        if(!potionBag.isEmpty())
            potionBag.clear();
    }
}
