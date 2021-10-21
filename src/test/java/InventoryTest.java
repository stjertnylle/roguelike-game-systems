import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Player player = new Player(1) {
        @Override
        public void increaseXP(int xp){

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
    Player highLevelPlayer = new Player(40) {
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
        player.equipWeapon(new DoubleAxe());
        assertTrue(inventory.isFull());
    }

    @Test
    void maxCapacity(){
        assertEquals(30, highLevelPlayer.getPlayerInventory().maxSize());
    }

    @Test
    void addingSameWeaponTwice(){
        SwiftAxe swiftAxe = new SwiftAxe();
        inventory.addWeapon(swiftAxe);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> inventory.addWeapon(swiftAxe));
        assertEquals("Inventory already contains Swift Axe", e.getMessage());
    }

    @Test
    void addingWeaponFullInventory(){
        for(int i = 0; i < 6; i++){
            inventory.addWeapon(new SwiftAxe());
        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> inventory.addWeapon(new SwiftAxe()));
        assertEquals("Inventory full, cannot add Swift Axe", e.getMessage());
    }

    @Test
    void removeWeaponNotInInventory(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> inventory.removeWeapon(new SwiftAxe()));
        assertEquals("Inventory does not contain Swift Axe", e.getMessage());
    }

    @Test
    void inventoryNotFullWhenEmpty(){
        assertFalse(inventory.isFull());
    }

    @Test
    void inventoryNotFullAndNotEmpty(){
        inventory.addWeapon(new SwiftAxe());
        assertFalse(inventory.isFull());
    }

    @Test
    void testNoEquippedBeginnerWeapon(){
        assertNull(player.getWeapon());
    }

    @Test
    void testEquipOtherWeapon(){
        player.setWeapon(new DoubleAxe());
        assertEquals(player.getWeapon().getWeaponName(), new DoubleAxe().getWeaponName());
    }

    @Test
    void previousWeaponToInventory(){
        Weapon startWeapon = player.getWeapon();
        Weapon firstDoubleAxe = new DoubleAxe();
        DoubleAxe secondDoubleAxe = new DoubleAxe();

        player.equipWeapon(firstDoubleAxe);
        assertTrue(inventory.getWeapons().contains(startWeapon));
        assertFalse(inventory.getWeapons().contains(firstDoubleAxe));

        inventory.addWeapon(secondDoubleAxe);
        player.equipWeapon(secondDoubleAxe);
        assertTrue(inventory.getWeapons().contains(startWeapon));
        assertTrue(inventory.getWeapons().contains(firstDoubleAxe));
        assertFalse(inventory.getWeapons().contains(secondDoubleAxe));
    }
}
