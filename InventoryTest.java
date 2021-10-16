import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Player player = new Player(1);
    Inventory inventory = player.getPlayerInventory();

    @Test
    void testNewInventorySize(){
        assertEquals(player.getPlayerInventory().maxSize(), 6);
    }
    @Test
    void testOwner(){
        assertEquals(inventory.getOwner(), player);
    }

    @Test
    void testSizeAfterLevelUp(){
        player.levelUP();
        assertEquals(inventory.maxSize(), 7);
    }

    @Test
    void inventoryFull() {
        for(int i = 0; i < 6; i++){
            inventory.addWeapon(new SwiftAxe());
        }
        assertEquals(inventory.isFull(), true);
    }
    @Test
    void inventoryNotFullWhenEmpty(){
        assertEquals(inventory.isFull(), false);
    }

    @Test
    void inventoryNotFullWhenNotEmpty(){
        inventory.addWeapon(new SwiftAxe());
        assertEquals(inventory.isFull(), false);
    }
}
