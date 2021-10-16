import java.util.ArrayList;

public interface Player{
    int getHPValue();

    void decreaseHP(int amount);

    void increaseHP(int amount);

    int getManaValue();

    void decreaseMana(int amount);

    void increaseMana(int amount);

    boolean inventoryFull();

    ArrayList<Weapon> getInventory();

    void consumePotion(Potion potion);

    void equip(Weapon weapon);

    int getLevel();

    void rewardExp(int gainedExp);

    Action getAction();
}
