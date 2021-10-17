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
        public Weapon getWeapon() {
            return new NoModifierWeapon();
        }

        @Override
        Action getAction(){
            return lightAttackFromPlayer;
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
        Player standardPlayerWithHeavyAttack = new Player(10) {
            @Override
            public Element getElement(){
                return null;
            }

            @Override
            public void increaseXP(int xp){

            }

            @Override
            public Weapon getWeapon() {
                return new NoModifierWeapon();
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
            public Weapon getWeapon() {
                return new NoModifierWeapon();
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
            public Weapon getWeapon() {
                return new NoModifierWeapon();
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

    @Test
    void playerIsAwardedXPWhenEndCombatIsCalled(){
       Player playerLevelOne = new Player(1) {
           @Override
           Action getAction(){
               return null;
           }

           @Override
           public Element getElement(){
               return null;
           }
       };
        combat.endCombat(playerLevelOne, monsterWithLowHPSlowAttack);
        assertEquals(2, playerLevelOne.getLevel().getCurrentLevel());
    }

    @Test
    void playerIsAwardedXpWhenTheyWinCombat(){
        Player playerLevelOne = new Player(1) {
            @Override
            Action getAction(){
                return lightAttackFromPlayer;
            }

            @Override
            public Element getElement(){
                return null;
            }
        };
        new Combat(playerLevelOne,monsterWithLowHPSlowAttack).startCombat();
        assertEquals(2, playerLevelOne.getLevel().getCurrentLevel());
    }

}
