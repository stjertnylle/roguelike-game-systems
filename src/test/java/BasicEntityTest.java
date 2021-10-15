import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicEntityTest {

    @Test
    void testLevelSetCorrectly() {
        Entity entity = new BasicEntity(10);
        assertEquals(10, entity.getLevel());
    }

    @Test
    void testExceptionThrownIfLevelBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BasicEntity(-1));
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfLevelEqualToZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BasicEntity(0));
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testMaxHPSetCorrectly() {
        Entity entity = new BasicEntity(10);
        assertEquals(100, entity.getMaxHP());
    }

    @Test
    void testMaxManaSetCorrectly() {
        Entity entity = new BasicEntity(10);
        assertEquals(100, entity.getMaxMana());
    }

    @Test
    void testDecreaseHealth() {
        Entity entity = new BasicEntity(10);
        entity.decreaseHP(10);
        assertEquals(90, entity.getCurrentHP());
    }

    @Test
    void testIncreaseHealth() {
        Entity entity = new BasicEntity(10);
        entity.setHP(80);
        entity.increaseHP(10);
        assertEquals(90, entity.getCurrentHP());
    }

    @Test
    void testHPSetToMaxHPIfMaxExceeded() {
        Entity entity = new BasicEntity(10);
        entity.setHP(80);
        entity.increaseHP(30);
        assertEquals(100, entity.getCurrentHP());
    }

    @Test
    void testHealthRatioCalculatedCorrectly() {
        Entity entity = new BasicEntity(10);
        entity.setHP(80);
        assertEquals(0.80, entity.getHealthRatio());
    }

    @Test
    void testDecreaseMana() {
        Entity entity = new BasicEntity(10);
        entity.decreaseMana(10);
        assertEquals(90, entity.getCurrentMana());
    }

    @Test
    void testManaSetToZeroIfNegative() {
        Entity entity = new BasicEntity(10);
        entity.decreaseMana(110);
        assertEquals(0, entity.getCurrentMana());
    }

    @Test
    void testIncreaseMana() {
        Entity entity = new BasicEntity(10);
        entity.setMana(80);
        entity.increaseMana(10);
        assertEquals(90, entity.getCurrentMana());
    }

    @Test
    void testManaSetToMaxManaIfMaxExceeded() {
        Entity entity = new BasicEntity(10);
        entity.setMana(80);
        entity.increaseMana(30);
        assertEquals(100, entity.getCurrentMana());
    }

}