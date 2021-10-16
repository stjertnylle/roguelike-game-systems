import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PotionInventoryTest {
    PotionInventory potionInventory = new PotionInventory();
    HealthPotion healthPotion = new HealthPotion();

    @Test
    void testEmptyBag(){
        assertEquals(potionInventory.contains(healthPotion), false);
        assertEquals(potionInventory.count(healthPotion), 0);
    }
    @Test
    void testNotEmptyBag(){
        potionInventory.add(healthPotion);
        assertEquals(potionInventory.contains(healthPotion), true);
        assertEquals(potionInventory.count(healthPotion), 1);
    }
    @Test
    void testEmptyBagAfterUse(){
        potionInventory.add(healthPotion);
        potionInventory.remove(healthPotion);
        assertEquals(potionInventory.contains(healthPotion), false);
        assertEquals(potionInventory.count(healthPotion), 0);
    }

    @Test
    void testAddingMutliple(){
        potionInventory.add(healthPotion);
        potionInventory.add(healthPotion);
        potionInventory.add(healthPotion);

        assertEquals(potionInventory.contains(healthPotion), true);
        assertEquals(potionInventory.count(healthPotion), 3);
    }

    @Test
    void removeNonExisting(){
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> potionInventory.remove(healthPotion));
        assertEquals("There is no such potion to remove", e.getMessage());
    }
}
