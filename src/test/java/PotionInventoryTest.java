import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PotionInventoryTest {
    Player player = new Player(1) {
        @Override
        Action getAction() {
            return null;
        }

        @Override
        public Element getElement() {
            return null;
        }
    };
    PotionInventory potionInventory = player.getPotionInventory();
    SmallHealthPotion smallHealthPotion = new SmallHealthPotion();
    LargeHealthPotion largeHealthPotion = new LargeHealthPotion();

    @Test
    void testEmptyBag(){
        assertEquals(potionInventory.contains(smallHealthPotion), false);
        assertEquals(potionInventory.count(smallHealthPotion), 0);
    }
    @Test
    void testNotEmptyBag(){
        potionInventory.add(smallHealthPotion);
        assertEquals(potionInventory.contains(smallHealthPotion), true);
        assertEquals(potionInventory.count(smallHealthPotion), 1);
    }
    @Test
    void testEmptyBagAfterUse(){
        potionInventory.add(smallHealthPotion);
        potionInventory.remove(smallHealthPotion);
        assertEquals(potionInventory.contains(smallHealthPotion), false);
        assertEquals(potionInventory.count(smallHealthPotion), 0);
    }

    @Test
    void testAddingMutliple(){
        potionInventory.add(smallHealthPotion);
        potionInventory.add(smallHealthPotion);
        potionInventory.add(smallHealthPotion);
        potionInventory.add(largeHealthPotion);
        potionInventory.add(largeHealthPotion);

        assertEquals(potionInventory.contains(smallHealthPotion), true);
        assertEquals(potionInventory.count(smallHealthPotion), 3);
        assertEquals(potionInventory.count(largeHealthPotion), 2);
    }

    @Test
    void removeNonExisting(){
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> potionInventory.remove(smallHealthPotion));
        assertEquals("There is no such potion to remove", e.getMessage());
    }
}
