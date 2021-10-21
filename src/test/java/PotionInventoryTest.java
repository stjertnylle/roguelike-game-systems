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
        assertFalse(potionInventory.contains(smallHealthPotion));
        assertEquals(potionInventory.count(smallHealthPotion), 0);
    }
    @Test
    void testNotEmptyBag(){
        potionInventory.add(smallHealthPotion);
        assertTrue(potionInventory.contains(smallHealthPotion));
        assertEquals(potionInventory.count(smallHealthPotion), 1);
    }
    @Test
    void testEmptyBagAfterUse(){
        potionInventory.add(smallHealthPotion);
        potionInventory.add(smallHealthPotion);
        potionInventory.remove(smallHealthPotion);
        potionInventory.remove(smallHealthPotion);
        assertFalse(potionInventory.contains(smallHealthPotion));
        assertEquals(potionInventory.count(smallHealthPotion), 0);
    }

    @Test
    void testAddingMultiple(){
        potionInventory.add(smallHealthPotion);
        potionInventory.add(smallHealthPotion);
        potionInventory.add(smallHealthPotion);
        potionInventory.add(largeHealthPotion);
        potionInventory.add(largeHealthPotion);

        assertTrue(potionInventory.contains(smallHealthPotion));
        assertEquals(potionInventory.count(smallHealthPotion), 3);
        assertEquals(potionInventory.count(largeHealthPotion), 2);
    }

    @Test
    void removeNonExisting(){
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> potionInventory.remove(smallHealthPotion));
        assertEquals("There is no such potion to remove", e.getMessage());
    }
}
