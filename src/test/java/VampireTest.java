import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {
    // This object is used in all the tests
    Vampire vampire = new Vampire(10);

    // The following test is simply included to demonstrate the difficulty of naming these tests properly.
    // This is the reason why the rest of the names aren't very descriptive.

    @Test
    void Should_ChooseWindSlash_When_PlayerHealthRatioIsLessThanTwentyPercentAndManaRatioHigherThanOrEqualToTwentyPercent() {
        vampire.setMana(50);
        assertEquals(WindSlash.class, vampire.getAction(0.1).getClass());
    }

    // 24 tests covering the decision tree made for the method getAction() in Vampire.
    // Most of the tests also utilize boundary value testing.
    @Test
    void testWindSlashChosenWhenConditionsMatch1() {
        vampire.setMana(50);
        vampire.setHP(19);
        assertEquals(WindSlash.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch2() {
        vampire.setMana(30);
        vampire.setHP(19);
        assertEquals(WindSlash.class, vampire.getAction(0.01).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch3() {
        vampire.setMana(20);
        vampire.setHP(19);
        assertEquals(WindSlash.class, vampire.getAction(0.19).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch4() {
        vampire.setMana(50);
        vampire.setHP(20);
        assertEquals(WindSlash.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch5() {
        vampire.setMana(30);
        vampire.setHP(35);
        assertEquals(WindSlash.class, vampire.getAction(0.01).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch6() {
        vampire.setMana(20);
        vampire.setHP(49);
        assertEquals(WindSlash.class, vampire.getAction(0.19).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch7() {
        vampire.setMana(50);
        vampire.setHP(50);
        assertEquals(WindSlash.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch8() {
        vampire.setMana(30);
        vampire.setHP(50);
        assertEquals(WindSlash.class, vampire.getAction(0.01).getClass());
    }

    @Test
    void testWindSlashChosenWhenConditionsMatch9() {
        vampire.setMana(20);
        vampire.setHP(50);
        assertEquals(WindSlash.class, vampire.getAction(0.19).getClass());
    }

    @Test
    void testLightAttackChosenWhenConditionsMatch1() {
        vampire.setHP(19);
        vampire.setMana(19);
        assertEquals(LightAttack.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testLightAttackChosenWhenConditionsMatch2() {
        vampire.setHP(20);
        vampire.setMana(19);
        assertEquals(LightAttack.class, vampire.getAction(0.01).getClass());
    }

    @Test
    void testLightAttackChosenWhenConditionsMatch3() {
        vampire.setHP(50);
        vampire.setMana(19);
        assertEquals(LightAttack.class, vampire.getAction(0.19).getClass());
    }

    @Test
    void testHealSpellChosenWhenConditionsMatch1() {
        vampire.setHP(19);
        vampire.setMana(50);
        assertEquals(HealingSpell.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHealSpellChosenWhenConditionsMatch2() {
        vampire.setHP(19);
        vampire.setMana(30);
        assertEquals(HealingSpell.class, vampire.getAction(0.99).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch1() {
        vampire.setHP(19);
        vampire.setMana(20);
        assertEquals(LifeSteal.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch2() {
        vampire.setHP(20);
        vampire.setMana(50);
        assertEquals(LifeSteal.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch3() {
        vampire.setHP(49);
        vampire.setMana(30);
        assertEquals(LifeSteal.class, vampire.getAction(0.99).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch4() {
        vampire.setHP(35);
        vampire.setMana(20);
        assertEquals(LifeSteal.class, vampire.getAction(0.99).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch1() {
        vampire.setHP(19);
        vampire.setMana(19);
        assertEquals(HeavyAttack.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch2() {
        vampire.setHP(20);
        vampire.setMana(19);
        assertEquals(HeavyAttack.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch3() {
        vampire.setHP(50);
        vampire.setMana(50);
        assertEquals(HeavyAttack.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch4() {
        vampire.setHP(50);
        vampire.setMana(30);
        assertEquals(HeavyAttack.class, vampire.getAction(0.99).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch5() {
        vampire.setHP(50);
        vampire.setMana(20);
        assertEquals(HeavyAttack.class, vampire.getAction(0.99).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch6() {
        vampire.setHP(50);
        vampire.setMana(19);
        assertEquals(HeavyAttack.class, vampire.getAction(0.99).getClass());
    }

    // Testing exp reward
    @Test
    void testExpRewardCalculatedCorrectly() {
        assertEquals(100, vampire.getExpReward());
    }

    // Testing exceptions when playerHealthRatio argument is not within required range
    @Test
    void testExceptionThrownWhenPlayerHealthRatioAboveOne() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> vampire.getAction(1.01));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

    @Test
    void testExceptionThrownWhenPlayerHealthRatioBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> vampire.getAction(-1));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

    @Test
    void testExceptionThrownWhenPlayerHealthRatioEqualToZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> vampire.getAction(0));
        assertEquals("Player health ratio must be within range 0 < x >= 1", e.getMessage());
    }

}