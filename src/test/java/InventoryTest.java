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

    @Test
    void testEquippedBeginnerWeapon(){
        assertEquals(player.getWeapon().getWeaponName(), new SwiftAxe().getWeaponName());
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
