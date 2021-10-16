import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    StandardPlayer player = new StandardPlayer(10);
    Vampire vampire = new Vampire(20);
    LightAttack lightAttack = new LightAttack(10);
    LightAttack lightAttack2 = new LightAttack(10);
    HeavyAttack heavyAttack = new HeavyAttack(10);
    Combat combat = new Combat(player,vampire);

    @Test
    void getFastestAction(){
        assertEquals(lightAttack, combat.getFastestAction(lightAttack, heavyAttack));
    }

    @Test
    void getFastestActionWhenBothActionsSameSpeed(){
        assertEquals(lightAttack, combat.getFastestAction(lightAttack, lightAttack2));
    }



}
