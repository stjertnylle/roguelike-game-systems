import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    Element earth = new Earth();
    Element fire = new Fire();
    Element water = new Water();
    Element air = new Air();

    @Test
    void testWaterAgainstFire() {
        assertEquals(1.5, water.getModifierAgainst(fire));
    }

    @Test
    void testWaterAgainstEarth() {
        assertEquals(0.5, water.getModifierAgainst(earth));
    }

    @Test
    void testWaterAgainstAir() {
        assertEquals(1, water.getModifierAgainst(air));
    }

    @Test
    void testWaterAgainstWater() {
        assertEquals(1, water.getModifierAgainst(water));
    }

    @Test
    void testExceptionThrownIfElementSentToWaterIsNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> water.getModifierAgainst(null));
        assertEquals("Argument can not be null!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfElementSentToWaterDoesNotExistInSystem() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> water.getModifierAgainst(new Element() {
            @Override
            public double getModifierAgainst(Element element) {
                return 0;
            }
        }));
    }

    @Test
    void testFireAgainstWater() {
        assertEquals(0.5, fire.getModifierAgainst(water));
    }

    @Test
    void testFireAgainstAir() {
        assertEquals(1.5, fire.getModifierAgainst(air));
    }

    @Test
    void testFireAgainstEarth() {
        assertEquals(1, fire.getModifierAgainst(earth));
    }

    @Test
    void testFireAgainstFire() {
        assertEquals(1, fire.getModifierAgainst(fire));
    }

    @Test
    void testExceptionThrownIfElementSentToFireIsNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> fire.getModifierAgainst(null));
        assertEquals("Argument can not be null!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfElementSentToFireDoesNotExistInSystem() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> fire.getModifierAgainst(new Element() {
            @Override
            public double getModifierAgainst(Element element) {
                return 0;
            }
        }));
    }

    @Test
    void testAirAgainstEarth() {
        assertEquals(1.5, air.getModifierAgainst(earth));
    }

    @Test
    void testAirAgainstFire() {
        assertEquals(0.5, air.getModifierAgainst(fire));
    }

    @Test
    void testAirAgainstWater() {
        assertEquals(1, air.getModifierAgainst(water));
    }

    @Test
    void testAirAgainstAir() {
        assertEquals(1, air.getModifierAgainst(air));
    }

    @Test
    void testExceptionThrownIfElementSentToAirIsNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> air.getModifierAgainst(null));
        assertEquals("Argument can not be null!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfElementSentToAirDoesNotExistInSystem() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> air.getModifierAgainst(new Element() {
            @Override
            public double getModifierAgainst(Element element) {
                return 0;
            }
        }));
    }

    @Test
    void testEarthAgainstWater() {
        assertEquals(1.5, earth.getModifierAgainst(water));
    }

    @Test
    void testEarthAgainstAir() {
        assertEquals(0.5, earth.getModifierAgainst(air));
    }

    @Test
    void testEarthAgainstFire() {
        assertEquals(1, earth.getModifierAgainst(fire));
    }

    @Test
    void testEarthAgainstEarth() {
        assertEquals(1, earth.getModifierAgainst(earth));
    }

    @Test
    void testExceptionThrownIfElementSentToEarthIsNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> earth.getModifierAgainst(null));
        assertEquals("Argument can not be null!", e.getMessage());
    }

    @Test
    void testExceptionThrownIfElementSentToEarthDoesNotExistInSystem() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> earth.getModifierAgainst(new Element() {
            @Override
            public double getModifierAgainst(Element element) {
                return 0;
            }
        }));
    }

}