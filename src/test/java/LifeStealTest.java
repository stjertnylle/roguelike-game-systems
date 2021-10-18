import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeStealTest {

    Player level10Player = new Player(10) {

        @Override
        Action getAction() {
            return null;
        }

        @Override
        public Element getElement() {
            return null;
        }
    };


    @Test
    void testDamageCalculatedCorrectly() {
        LifeSteal lifeSteal = new LifeSteal(new Vampire(10));
        assertEquals(10, lifeSteal.getDamage());
    }

    @Test
    void testManaCostCalculatedCorrectly() {
        LifeSteal lifeSteal = new LifeSteal(new Vampire(10));
        assertEquals(20, lifeSteal.getManaCost());
    }

    @Test
    void testSpeedHasExpectedValue() {
        LifeSteal lifeSteal = new LifeSteal(new Vampire(10));
        assertEquals(4, lifeSteal.getSpeed());
    }

    @Test
    void testPlayerTakesCorrectDamage() {
        LifeSteal lifeSteal = new LifeSteal(new Vampire(10));
        lifeSteal.apply(level10Player);
        assertEquals(90, level10Player.getCurrentHP());
    }

    @Test
    void testUserIsHealedByEqualAmountToDamage() {
        Vampire level10Vampire = new Vampire(10);
        LifeSteal lifeSteal = new LifeSteal(level10Vampire);
        level10Vampire.setHP(80);
        lifeSteal.apply(level10Player);
        assertEquals(90, level10Vampire.getCurrentHP());
    }

    @Test
    void testManaCostAppliedCorrectlyToUser() {
        Vampire level10Vampire = new Vampire(10);
        LifeSteal lifeSteal = new LifeSteal(level10Vampire);
        lifeSteal.apply(level10Player);
        assertEquals(80, level10Vampire.getCurrentMana());
    }

}