import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {

    @Test
    void testLevelSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(10, monster.getLevel());
    }

    @Test
    void testExceptionThrownIfLevelBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BasicMonster(-1));
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfLevelEqualToZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BasicMonster(0));
        assertEquals("Level must be higher than 0!", e.getMessage());
    }

    @Test
    void testMaxHPSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getMaxHP());
    }

    @Test
    void testMaxManaSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getMaxMana());
    }

    @Test
    void testExpRewardCalculatedCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getExpReward());
    }

    @Test
    void testDecreaseHealth() {
        Monster monster = new BasicMonster(10);
        monster.decreaseHP(10);
        assertEquals(90, monster.getCurrentHP());
    }

    @Test
    void testIncreaseHealth() {
        Monster monster = new BasicMonster(10);
        monster.setHP(80);
        monster.increaseHP(10);
        assertEquals(90, monster.getCurrentHP());
    }

    @Test
    void testHPSetToMaxHPIfMaxExceeded() {
        Monster monster = new BasicMonster(10);
        monster.setHP(80);
        monster.increaseHP(30);
        assertEquals(100, monster.getCurrentHP());
    }

    @Test
    void testHealthRatioCalculatedCorrectly() {
        Monster monster = new BasicMonster(10);
        monster.setHP(80);
        assertEquals(0.80, monster.getHealthRatio());
    }

    @Test
    void testDecreaseMana() {
        Monster monster = new BasicMonster(10);
        monster.decreaseMana(10);
        assertEquals(90, monster.getCurrentMana());
    }

    @Test
    void testManaSetToZeroIfNegative() {
        Monster monster = new BasicMonster(10);
        monster.decreaseMana(110);
        assertEquals(0, monster.getCurrentMana());
    }

    @Test
    void testIncreaseMana() {
        Monster monster = new BasicMonster(10);
        monster.setMana(80);
        monster.increaseMana(10);
        assertEquals(90, monster.getCurrentMana());
    }

    @Test
    void testManaSetToMaxManaIfMaxExceeded() {
        Monster monster = new BasicMonster(10);
        monster.setMana(80);
        monster.increaseMana(30);
        assertEquals(100, monster.getCurrentMana());
    }

}