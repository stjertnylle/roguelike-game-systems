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

}