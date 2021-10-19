import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class WeaponTest {
    @Test
    void newSwiftAxe(){
        SwiftAxe swiftAxe = new SwiftAxe();
        assertEquals(1, swiftAxe.getSpeedModifier());
        assertEquals(1, swiftAxe.getDamageModifier());
    }
    @Test
    void newDoubleAxe(){
        DoubleAxe doubleAxe = new DoubleAxe();
        assertEquals(1.7, doubleAxe.getDamageModifier());
        assertEquals(0.3, doubleAxe.getSpeedModifier());
    }
}
