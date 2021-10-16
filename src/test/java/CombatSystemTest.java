import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    Player player = new Player() {
        @Override
        public int getHPValue(){
            return 0;
        }

        @Override
        public void decreaseHP(int amount){

        }

        @Override
        public void increaseHP(int amount){

        }

        @Override
        public int getManaValue(){
            return 0;
        }

        @Override
        public void decreaseMana(int amount){

        }

        @Override
        public void increaseMana(int amount){

        }

        @Override
        public boolean inventoryFull(){
            return false;
        }

        @Override
        public ArrayList<Weapon> getInventory(){
            return null;
        }

        @Override
        public void consumePotion(Potion potion){

        }

        @Override
        public void equip(Weapon weapon){

        }

        @Override
        public int getLevel(){
            return 0;
        }

        @Override
        public void rewardExp(int gainedExp){

        }

        @Override
        public Action getAction(){
            return lightAttackFromPlayer;
        }
    };
    StandardPlayer standardplayer = new StandardPlayer(10);
    Vampire vampire = new Vampire(20);
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



}
