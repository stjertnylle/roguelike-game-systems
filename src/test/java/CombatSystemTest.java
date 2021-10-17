import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    Player player = new Player(10) {
        @Override
        public Element getElement(){
            return null;
        }

        @Override
        public void increaseXP(int xp){

        }

        @Override
        Action getAction(){
            return lightAttackFromPlayer;
        }
    };
    MonsterWithLowHPSlowAttack monsterWithLowHPSlowAttack = new MonsterWithLowHPSlowAttack(10);
    MonsterWithLowHPFastAttack monsterWithLowHPFastAttack = new MonsterWithLowHPFastAttack(10);
    LightAttack lightAttackFromPlayer = new LightAttack(10);
    LightAttack lightAttackFromMonster = new LightAttack(10);
    HeavyAttack heavyAttack = new HeavyAttack(10);
    Combat combat = new Combat(player,monsterWithLowHPSlowAttack);

    @Test
    void getFastestAction(){
        assertEquals(lightAttackFromPlayer,combat.getFastestAction(lightAttackFromPlayer,heavyAttack));
    }

    @Test
    void getFastestActionWhenBothActionsSameSpeed(){
        assertEquals(lightAttackFromPlayer,combat.getFastestAction(lightAttackFromPlayer,lightAttackFromMonster));
    }

    @Test
    void combatEndsWhenHPLessThanZeroForMonster(){
        monsterWithLowHPSlowAttack.setHP(1);
        combat.startCombat();
        assertTrue(monsterWithLowHPSlowAttack.getCurrentHP() < 0);
    }

    @Test
    void startCombatReturnsCorrectWinnerWhenItIsPlayer(){
        monsterWithLowHPSlowAttack.setHP(1);
        combat.startCombat();
        assertEquals(player,combat.startCombat());
    }

    @Test
    void monsterDoesNotGetToHitWhenItDies(){
        player.setHP(1);
        monsterWithLowHPSlowAttack.setHP(1);
        combat.startCombat();
        assertEquals(1,player.getCurrentHP());
    }

    @Test
    void combatEndsWhenHPLessThanZeroForPlayer(){
        Player standardPlayerWithHeavyAttack = new Player(10) {
            @Override
            public Element getElement(){
                return null;
            }

            @Override
            public void increaseXP(int xp){

            }

            @Override
            Action getAction(){
                return heavyAttack;
            }
        };
        standardPlayerWithHeavyAttack.setHP(1);
        new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertTrue(standardPlayerWithHeavyAttack.getCurrentHP() < 0);
    }

    @Test
    void startCombatReturnsCorrectWinnerWhenItIsMonster(){
        Player standardPlayerWithHeavyAttack = new Player(10) {
            @Override
            public Element getElement(){
                return null;
            }

            @Override
            public void increaseXP(int xp){

            }

            @Override
            Action getAction(){
                return heavyAttack;
            }
        };
        standardPlayerWithHeavyAttack.setHP(1);
        Entity winnerOfCombat = new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertEquals(monsterWithLowHPFastAttack,winnerOfCombat);
    }

    @Test
    void PlayerDoesNotGetToHitWhenItDies(){
        Player standardPlayerWithHeavyAttack = new Player(10) {
            @Override
            public Element getElement(){
                return null;
            }

            @Override
            public void increaseXP(int xp){

            }

            @Override
            Action getAction(){
                return heavyAttack;
            }
        };
        standardPlayerWithHeavyAttack.setHP(1);
        monsterWithLowHPFastAttack.setHP(1);
        new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertEquals(1,monsterWithLowHPFastAttack.getCurrentHP());
    }

}
