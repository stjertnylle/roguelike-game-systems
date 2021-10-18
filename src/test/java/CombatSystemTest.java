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
        public Weapon getWeapon(){
            return new NoModifierWeapon();
        }

        @Override
        Action getAction(){
            return lightAttackFromPlayer;
        }
    };

    Player playerLevelOne = new Player(1) {
        @Override
        Action getAction(){
            return lightAttackFromPlayer;
        }

        @Override
        public Weapon getWeapon(){
            return new NoModifierWeapon();
        }

        @Override
        public Element getElement(){
            return null;
        }
    };

    Player standardPlayerWithHeavyAttack = new Player(10) {
        @Override
        public Element getElement(){
            return null;
        }

        @Override
        public void increaseXP(int xp){

        }

        @Override
        public Weapon getWeapon(){
            return new NoModifierWeapon();
        }

        @Override
        Action getAction(){
            return heavyAttack;
        }
    };

    MonsterWithLowHPSlowAttack monsterWithLowHPSlowAttack = new MonsterWithLowHPSlowAttack(10);
    MonsterWithLowHPFastAttack monsterWithLowHPFastAttack = new MonsterWithLowHPFastAttack(10);
    LightAttack lightAttackFromPlayer = new LightAttack(player);
    LightAttack lightAttackFromMonster = new LightAttack(player);
    HeavyAttack heavyAttack = new HeavyAttack(player);
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

        standardPlayerWithHeavyAttack.setHP(1);
        new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertTrue(standardPlayerWithHeavyAttack.getCurrentHP() < 0);
    }

    @Test
    void startCombatReturnsCorrectWinnerWhenItIsMonster(){
        standardPlayerWithHeavyAttack.setHP(1);
        Entity winnerOfCombat = new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertEquals(monsterWithLowHPFastAttack,winnerOfCombat);
    }

    @Test
    void PlayerDoesNotGetToHitWhenItDies(){
        standardPlayerWithHeavyAttack.setHP(1);
        monsterWithLowHPFastAttack.setHP(1);
        new Combat(standardPlayerWithHeavyAttack,monsterWithLowHPFastAttack).startCombat();
        assertEquals(1,monsterWithLowHPFastAttack.getCurrentHP());
    }

    @Test
    void playerIsAwardedXPWhenEndCombatIsCalled(){
        combat.endCombat(playerLevelOne,monsterWithLowHPSlowAttack);
        assertEquals(2,playerLevelOne.getLevel().getCurrentLevel());
    }

    @Test
    void playerIsAwardedXpWhenTheyWinCombat(){
        new Combat(playerLevelOne,monsterWithLowHPSlowAttack).startCombat();
        assertEquals(2,playerLevelOne.getLevel().getCurrentLevel());
    }

    @Test
    void playerLevelIsResetWhenGameOverIsCalled(){
        Combat combat = new Combat(standardPlayerWithHeavyAttack, monsterWithLowHPFastAttack);
        combat.gameOver(standardPlayerWithHeavyAttack);
        assertEquals(1, standardPlayerWithHeavyAttack.getLevel().getCurrentLevel());
    }
    @Test
    void playerLevelIsResetWhenDefeated(){
        new Combat(standardPlayerWithHeavyAttack, monsterWithLowHPFastAttack).startCombat();
        standardPlayerWithHeavyAttack.setHP(1);
        assertEquals(1, standardPlayerWithHeavyAttack.getLevel().getCurrentLevel());
    }

}
