import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    @Test
    void testWaterAgainstFire() {
        Element water = new Water();
        Element fire = new Fire();
        assertEquals(1.5, water.getModifierAgainst(fire));
    }

    @Test
    void testWaterAgainstEarth() {
        Element water = new Water();
        Element earth = new Earth();
        assertEquals(0.5, water.getModifierAgainst(earth));
    }

    @Test
    void testWaterAgainstAir() {
        Element water = new Water();
        Element air = new Air();
        assertEquals(1, water.getModifierAgainst(air));
    }

    @Test
    void testWaterAgainstWater() {
        Element water = new Water();
        assertEquals(1, water.getModifierAgainst(water));
    }

    @Test
    void testFireAgainstWater() {
        Element fire = new Fire();
        Element water = new Water();
        assertEquals(0.5, fire.getModifierAgainst(water));
    }

    @Test
    void testFireAgainstAir() {
        Element fire = new Fire();
        Element air = new Air();
        assertEquals(1.5, fire.getModifierAgainst(air));
    }

    @Test
    void testFireAgainstEarth() {
        Element fire = new Fire();
        Element earth = new Earth();
        assertEquals(1, fire.getModifierAgainst(earth));
    }

    @Test
    void testFireAgainstFire() {
        Element fire = new Fire();
        assertEquals(1, fire.getModifierAgainst(fire));
    }

    @Test
    void testAirAgainstEarth() {
        Element air = new Air();
        Element earth = new Earth();
        assertEquals(1.5, air.getModifierAgainst(earth));
    }

    @Test
    void testAirAgainstFire() {
        Element air = new Air();
        Element fire = new Fire();
        assertEquals(0.5, air.getModifierAgainst(fire));
    }

    @Test
    void testAirAgainstWater() {
        Element air = new Air();
        Element water = new Water();
        assertEquals(1, air.getModifierAgainst(water));
    }

    @Test
    void testAirAgainstAir() {
        Element air = new Air();
        assertEquals(1, air.getModifierAgainst(air));
    }

    @Test
    void testEarthAgainstWater() {
        Element earth = new Earth();
        Element water = new Water();
        assertEquals(1.5, earth.getModifierAgainst(water));
    }

    @Test
    void testEarthAgainstAir() {
        Element earth = new Earth();
        Element air = new Air();
        assertEquals(0.5, earth.getModifierAgainst(air));
    }

    @Test
    void testEarthAgainstFire() {
        Element earth = new Earth();
        Element fire = new Fire();
        assertEquals(1, earth.getModifierAgainst(fire));
    }

    @Test
    void testEarthAgainstEarth() {
        Element earth = new Earth();
        assertEquals(1, earth.getModifierAgainst(earth));
    }

}