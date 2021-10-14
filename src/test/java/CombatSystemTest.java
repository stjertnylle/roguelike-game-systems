import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CombatSystemTest {
    Player player = new Player() {
        @Override
        public int getHPValue(){
            return 20;
        }
        @Override
        public void decreaseHP(int amount){}
        @Override
        public void increaseHP(int amount){}
        @Override
        public int getManaValue(){
            return 30;
        }
        @Override
        public void decreaseMana(int amount){}
        @Override
        public void increaseMana(int amount){}
        @Override
        public boolean inventoryFull(){
            return false;
        }
        @Override
        public ArrayList<Item> getInventory(){
            return null;
        }
        @Override
        public void consumePotion(Potion potion){}
        @Override
        public void equip(Weapon weapon){
        }
        @Override
        public int getLevel(){
            return 20;
        }
        @Override
        public void rewardExp(int gainedExp){}
        @Override
        public Action getAction(){
            return new LightAttack(10);
        }
    };

    Vampire vampire = new Vampire(20);
    LightAttack lightAttack = new LightAttack(10);
    HeavyAttack heavyAttack = new HeavyAttack(10);
    CombatSystem combatsystem = new CombatSystem(player,vampire);

    @Test
    void getFastestAction(){
        assertEquals(lightAttack,combatsystem.getFastestAction(lightAttack,heavyAttack));
    }
    @Test
    void getActionValueDamageFromDamageAction(){
        assertEquals(lightAttack.getDamage(),combatsystem.getActionValueDamage(lightAttack));
    }
    @Test
    void getActionValueHealingFromDamageAction(){
        assertEquals(0,combatsystem.getActionValueDamage(lightAttack));
    }
    @Test
    void getActionValueHealing(){
        HealingSpell healingSpell = new HealingSpell(10);
        assertEquals(healingSpell.getHealAmount(),combatsystem.getActionValueHealing(healingSpell));
    }
    @Test
    void getActionValueFromLifeSteal(){
        LifeSteal lifeSteal = new LifeSteal(10);
        assertEquals(lifeSteal.getDamage(),combatsystem.getActionValueHealing(lifeSteal));
        assertEquals(lifeSteal.getDamage(),combatsystem.getActionValueDamage(lifeSteal));
    }
    @Test
    void getMonsterHPAfterTurn(){
        Vampire vampire = new Vampire(20);
    }



}
