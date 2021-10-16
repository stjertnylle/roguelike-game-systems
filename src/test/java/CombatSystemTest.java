import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    StandardPlayer standardplayer = new StandardPlayer(10) {
        @Override
        Action getAction(){
            return lightAttackFromPlayer;
        }
    };
    Vampire vampire = new Vampire(50);
    LightAttack lightAttackFromPlayer = new LightAttack(10);
    LightAttack lightAttackFromMonster = new LightAttack(10);
    HeavyAttack heavyAttack = new HeavyAttack(10);
    Combat combat = new Combat(standardplayer,vampire);

    @Test
    void getFastestAction(){
        assertEquals(lightAttackFromPlayer, combat.getFastestAction(lightAttackFromPlayer, heavyAttack));
    }

    @Test
    void getFastestActionWhenBothActionsSameSpeed(){
        assertEquals(lightAttackFromPlayer, combat.getFastestAction(lightAttackFromPlayer, lightAttackFromMonster));
    }

    @Test
    void combatEndsWhenHPLessThanZero(){
        vampire.setHP(1);
        combat.startCombat();
        assertTrue(vampire.getCurrentHP() < 0);
    }

    @Test
    void startCombatReturnsCorrectWinner(){
        vampire.setHP(1);
        combat.startCombat();
        assertEquals(standardplayer, combat.startCombat());
    }

    @Test
    void monsterDoesNotGetToHitWhenItDies(){
        standardplayer.setHP(1);
        vampire.setHP(1);
        combat.startCombat();
        assertEquals(1, standardplayer.getCurrentHP());
    }



}
