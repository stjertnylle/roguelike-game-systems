import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Player player = new Player(1) {
        @Override
        public void increaseXP(int xp){

        }

        @Override
        public Weapon getWeapon() {
            return null;
        }

        @Override
        Action getAction() {
            return null;
        }

        @Override
        public Element getElement() {
            return null;
        }
    };
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
        player.getLevel().setCurrentLevel(2);
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
