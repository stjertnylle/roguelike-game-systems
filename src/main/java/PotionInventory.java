import java.util.HashMap;
import java.util.NoSuchElementException;

public class PotionInventory {
    private HashMap<Potion, Integer> potionBag = new HashMap<>();


    public void add(Potion potion) {
        if(!potionBag.containsKey(potion)){ //Om objektet inte redan finns, lägg till i mapen och sett counter till 1
            potionBag.put(potion, 1);
        }
        else{
            potionBag.put(potion, potionBag.get(potion) + 1);//Existerar redan objektet, öka counter
        }
    }

    public boolean contains(Potion potion) {
        return potionBag.containsKey(potion);
    }

    public int count(Potion potion) {
        return potionBag.getOrDefault(potion, 0);//Returnerar värdet på nyckeln(hur många det finns),
        // om objektet inte hittas returnerars 0 (det finns inte)
    }

    public void remove(Potion potion) throws NoSuchElementException {
        try{
            if(this.count(potion) == 1){//Existerar endast 1 objekt
                potionBag.remove(potion);//ta bort det
            }
            else if(this.count(potion) > 1){                //Existerar fler än 1 objekt
                potionBag.put(potion, potionBag.get(potion) - 1);//Minska räknaren
            }
            else{                                                               //Annars (när det finns 0 objekt)
                throw new NoSuchElementException("finns inget sådant objekt");  //Throwa nytt exception, "Objektet finns inte"
            }


        }catch (NoSuchElementException e){                 //Här catchas exceptionet
            System.out.println(e);  //** Framgick inte huruvida Exceptionet skulle catchas (och skrivas ut till användaren)
            //** eller inte. Men jag valde att catcha Exceptionet, samt att skriva ut till användare
            //** för extra tydlighet
        }
    }
}
