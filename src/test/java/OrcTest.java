import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrcTest {
    Orc orc = new Orc(10);

    @Test
    void testLightAttackChosenWhenConditionsMatch1() {
        orc.setMana(30);
        assertEquals(LightAttack.class, orc.getAction(0.19).getClass());
    }

    @Test
    void testLightAttackChosenWhenConditionsMatch2() {
        orc.setMana(29);
        assertEquals(LightAttack.class, orc.getAction(0.19).getClass());
    }

    @Test
    void testFireStrikeChosenWhenConditionsMatch() {
        orc.setMana(30);
        assertEquals(FireStrike.class, orc.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch() {
        orc.setMana(29);
        assertEquals(HeavyAttack.class, orc.getAction(0.99).getClass());
    }

    @Test
    void testExpRewardCalculatedCorrectly() {
        assertEquals(50, orc.getExpReward());
    }

    // Testing exceptions when playerHealthRatio argument is not within required range
    @Test
    void testExceptionThrownWhenPlayerHealthRatioAboveOne() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> orc.getAction(1.01));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

    @Test
    void testExceptionThrownWhenPlayerHealthRatioBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> orc.getAction(-1));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

    @Test
    void testExceptionThrownWhenPlayerHealthRatioEqualToZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> orc.getAction(0));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

}