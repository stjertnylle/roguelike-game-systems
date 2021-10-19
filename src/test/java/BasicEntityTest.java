import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicEntityTest {

    Entity entity = new Entity(10) {

        @Override
        public Element getElement() {
            return null;
        }
    };

    @Test
    void testLevelSetCorrectly() {
        assertEquals(10, entity.getLevel().getCurrentLevel());
    }

    @Test
    void testExceptionThrownIfLevelBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Entity(-1) {
            @Override
            public Element getElement() {
                return null;
            }
        });
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfLevelEqualToZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Entity(0) {
            @Override
            public Element getElement() {
                return null;
            }
        });
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testMaxHPSetCorrectly() {
        assertEquals(100, entity.getMaxHP());
    }

    @Test
    void testMaxManaSetCorrectly() {
        assertEquals(100, entity.getMaxMana());
    }

    @Test
    void testDecreaseHealth() {
        entity.decreaseHP(10);
        assertEquals(90, entity.getCurrentHP());
    }

    @Test
    void testIncreaseHealth() {
        entity.setHP(80);
        entity.increaseHP(10);
        assertEquals(90, entity.getCurrentHP());
    }

    @Test
    void testHPSetToMaxHPIfMaxExceeded() {
        entity.setHP(80);
        entity.increaseHP(30);
        assertEquals(100, entity.getCurrentHP());
    }

    @Test
    void testHealthRatioCalculatedCorrectly() {
        entity.setHP(80);
        assertEquals(0.80, entity.getHealthRatio());
    }

    @Test
    void testDecreaseMana() {
        entity.decreaseMana(10);
        assertEquals(90, entity.getCurrentMana());
    }

    @Test
    void testManaSetToZeroIfNegative() {
        entity.decreaseMana(110);
        assertEquals(0, entity.getCurrentMana());
    }

    @Test
    void testIncreaseMana() {
        entity.setMana(80);
        entity.increaseMana(10);
        assertEquals(90, entity.getCurrentMana());
    }

    @Test
    void testManaSetToMaxManaIfMaxExceeded() {
        entity.setMana(80);
        entity.increaseMana(30);
        assertEquals(100, entity.getCurrentMana());
    }

}