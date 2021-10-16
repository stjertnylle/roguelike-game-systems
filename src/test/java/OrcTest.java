import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrcTest {

    @Test
    void testLightAttackChosenWhenConditionsMatch() {
        Orc orc = new Orc(10);
        assertEquals(LightAttack.class, orc.getAction(0.1).getClass());
    }

    @Test
    void testFireStrikeChosenWhenConditionsMatch() {
        Orc orc = new Orc(10);
        assertEquals(FireStrike.class, orc.getAction(0.3).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch() {
        Orc orc = new Orc(10);
        orc.setMana(20);
        assertEquals(HeavyAttack.class, orc.getAction(0.3).getClass());
    }

}