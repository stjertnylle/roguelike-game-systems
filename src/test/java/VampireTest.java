import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {

    @Test
    void testWindSlashChosenWhenConditionsMatch() {
        Vampire vampire = new Vampire(10);
        assertEquals(WindSlash.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testLightAttackChosenWhenConditionsMatch() {
        Vampire vampire = new Vampire(10);
        vampire.setMana(10);
        assertEquals(LightAttack.class, vampire.getAction(0.1).getClass());
    }

    @Test
    void testHealSpellChosenWhenConditionsMatch() {
        Vampire vampire = new Vampire(10);
        vampire.setHP(10);
        assertEquals(HealingSpell.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch1() {
        Vampire vampire = new Vampire(10);
        vampire.setHP(10);
        vampire.setMana(25);
        assertEquals(LifeSteal.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testLifeStealChosenWhenConditionsMatch2() {
        Vampire vampire = new Vampire(10);
        vampire.setHP(30);
        vampire.setMana(20);
        assertEquals(LifeSteal.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch1() {
        Vampire vampire = new Vampire(10);
        vampire.setHP(30);
        vampire.setMana(10);
        assertEquals(HeavyAttack.class, vampire.getAction(0.2).getClass());
    }

    @Test
    void testHeavyAttackChosenWhenConditionsMatch2() {
        Vampire vampire = new Vampire(10);
        assertEquals(HeavyAttack.class, vampire.getAction(0.2).getClass());
    }

}