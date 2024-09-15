import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    Player player = new Player(10) {
        @Override
        public Element getElement(){
            return null;
        }

        @Override
        public Weapon getWeapon(){
            return new Weapon("No Modifier Weapon") {

                @Override
                public double getDamageModifier() {
                    return 1;
                }

                @Override
                public double getSpeedModifier() {
                    return 1;
                }
            };
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
            return new Weapon("No Modifier Weapon") {

                @Override
                public double getDamageModifier() {
                    return 1;
                }

                @Override
                public double getSpeedModifier() {
                    return 1;
                }
            };
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
        Action getAction(){
            return heavyAttack;
        }
    };

    Monster monsterWithLowHPSlowAttack = new Monster(1) {

        @Override
        protected void initializeAvailableActions() {

        }

        @Override
        public Weapon getWeapon() {
            return new Weapon("No Modifier Weapon") {

                @Override
                public double getDamageModifier() {
                    return 1;
                }

                @Override
                public double getSpeedModifier() {
                    return 1;
                }
            };
        }

        @Override
        protected int getExpReward() {
            return 160;
        }

        @Override
        protected Action getAction(double playerHealthRatio) {
            return new HeavyAttack(this);
        }

        @Override
        public Element getElement() {
            return null;
        }

    };

    Monster monsterWithLowHPFastAttack = new Monster(1) {
        @Override
        protected void initializeAvailableActions() {

        }

        @Override
        public Weapon getWeapon() {
            return new Weapon("No Modifier Weapon") {

                @Override
                public double getDamageModifier() {
                    return 1;
                }

                @Override
                public double getSpeedModifier() {
                    return 1;
                }
            };
        }

        @Override
        protected int getExpReward() {
            return 0;
        }

        @Override
        protected Action getAction(double playerHealthRatio) {
            return new LightAttack(this);
        }

        @Override
        public Element getElement() {
            return null;
        }
    };

    LightAttack lightAttackFromPlayer = new LightAttack(playerLevelOne);
    LightAttack lightAttackFromMonster = new LightAttack(playerLevelOne);
    HeavyAttack heavyAttack = new HeavyAttack(player);
    Combat combat = new Combat(player,monsterWithLowHPSlowAttack);
    Weapon noModWeapon = new Weapon("No mod weapon"){

        @Override
        public double getDamageModifier(){
            return 1;
        }

        @Override
        public double getSpeedModifier(){
            return 1;
        }
    };

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
    void playerIsAwardedXpWhenTheyWinCombat(){
        monsterWithLowHPSlowAttack.setHP(1);
        new Combat(playerLevelOne,monsterWithLowHPSlowAttack).startCombat();
        assertEquals(2,playerLevelOne.getLevel().getCurrentLevel());
    }


    @Test
    void playerLevelIsResetWhenGameOverIsCalledViaStartCombat(){
        standardPlayerWithHeavyAttack.setHP(1);
        new Combat(standardPlayerWithHeavyAttack, monsterWithLowHPFastAttack).startCombat();
        assertEquals(1, standardPlayerWithHeavyAttack.getLevel().getCurrentLevel());
    }

    @Test
    void playerInventoryIsResetWhenWhenGameOverIsCalledViaStartCombat(){
        standardPlayerWithHeavyAttack.setHP(1);
        SwiftAxe swiftAxe  = new SwiftAxe();
        standardPlayerWithHeavyAttack.getPlayerInventory().addWeapon(swiftAxe);
        new Combat(standardPlayerWithHeavyAttack, monsterWithLowHPFastAttack).startCombat();
        assertFalse(standardPlayerWithHeavyAttack.getPlayerInventory().getWeapons().contains(swiftAxe));
    }

    @Test
    void playerPotionInventoryIsResetWhenGameOverIsCalledViaStartCombat(){
        standardPlayerWithHeavyAttack.setHP(1);
        SmallHealthPotion potion = new SmallHealthPotion();
        standardPlayerWithHeavyAttack.getPotionInventory().add(potion);
        new Combat(standardPlayerWithHeavyAttack, monsterWithLowHPFastAttack).startCombat();
        assertFalse(standardPlayerWithHeavyAttack.getPotionInventory().contains(potion));
    }

    @Test
    void bothPlayerAndMonsterSurviveATurnWhenBothHPMoreThanZero(){
        Monster monsterWhoDiesButNoXPReward = new Monster(1){
            @Override
            protected void initializeAvailableActions() {

            }

            @Override
            public Weapon getWeapon() {
                return new Weapon("No Modifier Weapon") {

                    @Override
                    public double getDamageModifier() {
                        return 1;
                    }

                    @Override
                    public double getSpeedModifier() {
                        return 1;
                    }
                };
            }

            @Override
            protected int getExpReward() {
                return 0;
            }

            @Override
            protected Action getAction(double playerHealthRatio) {
                return new HeavyAttack(this);
            }

            @Override
            public Element getElement() {
                return null;
            }

        };
        monsterWhoDiesButNoXPReward.setHP(4);
        playerLevelOne.setHP(4);
        new Combat(playerLevelOne, monsterWhoDiesButNoXPReward).startCombat();
        assertEquals(0,monsterWhoDiesButNoXPReward.getCurrentHP());
        assertEquals(1,playerLevelOne.getCurrentHP());
    }

    @Test
    void playerSurvivesFirstHitAndUsesAction(){
        Orc orc = new Orc(1){
            @Override
            protected Action getAction(double playerHealthRatio) {
                return new LightAttack(this);
            }
        };
        orc.setHP(4);
        orc.setWeapon(noModWeapon);
        standardPlayerWithHeavyAttack.setHP(4);
        new Combat(standardPlayerWithHeavyAttack, orc).startCombat();
        assertEquals(4-30,orc.getCurrentHP());
        assertEquals(2,standardPlayerWithHeavyAttack.getCurrentHP());
    }
}
