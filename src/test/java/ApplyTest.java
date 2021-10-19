import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ApplyTest {
    Player player = new Player(10) {
        @Override
        Action getAction() {
            return null;
        }

        @Override
        public Element getElement() {
            return null;
        }

        @Override
        public void setWeapon(Weapon weapon) {
            this.equipWeapon(new SwiftAxe());
        }
    };
    Vampire vampire = new Vampire(10);


    @Test
    void testLightAttack() {
        LightAttack la = new LightAttack(player);
        la.apply(vampire);
        assertEquals(90, vampire.getCurrentHP());
    }

    @Test
    void targetSelfLightAttack() {
        LightAttack la = new LightAttack(player);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> la.apply(player));
        assertEquals("Can't target self with attack", e.getMessage());
    }

    @Test
    void testHeavyAttack(){
        HeavyAttack ha = new HeavyAttack(player);
        ha.apply(vampire);
        assertEquals(85, vampire.getCurrentHP());
    }

    @Test
    void targetSelfHeavyAttack() {
        HeavyAttack ha = new HeavyAttack(player);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ha.apply(player));
        assertEquals("Can't target self with attack", e.getMessage());
    }

    @Test
    void testFireStrike(){
        FireStrike fs = new FireStrike(player);
        fs.apply(vampire);
        assertEquals(55, vampire.getCurrentHP());
        assertEquals(70, player.getCurrentMana());
    }

    @Test
    void fireStrikeNoMana(){
        FireStrike fs = new FireStrike(player);
        player.setMana(20);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> fs.apply(vampire));
        assertEquals("Not enough mana", e.getMessage());
    }

    @Test
    void targetSelfFireStrike() {
        FireStrike fs = new FireStrike(player);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> fs.apply(player));
        assertEquals("Can't target self with spell", e.getMessage());
    }

    @Test
    void testHealingSpell(){
        player.setHP(1);
        HealingSpell hs = new HealingSpell(player);
        hs.apply(player);
        assertEquals(31, player.getCurrentHP());
        assertEquals(70, player.getCurrentMana());
    }

    @Test
    void healingSpellNoMana() {
        HealingSpell hs = new HealingSpell(player);
        player.setMana(0);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> hs.apply(player));
        assertEquals("Not enough mana", e.getMessage());
    }

    @Test
    void targetMonsterHealingSpell(){
        HealingSpell hs = new HealingSpell(player);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> hs.apply(vampire));
        assertEquals("Can't target monster with spell", e.getMessage());
    }

    @Test
    void testWindSlash(){
        WindSlash ws = new WindSlash(player);
        ws.apply(vampire);
        assertEquals(80, vampire.getCurrentHP());
        assertEquals(80, player.getCurrentMana());
    }

    @Test
    void windSlashNoMana() {
        WindSlash ws = new WindSlash(player);
        player.setMana(-10);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> ws.apply(vampire));
        assertEquals("Not enough mana", e.getMessage());
    }

    @Test
    void targetSelfWindSlash() {
        WindSlash ws = new WindSlash(player);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ws.apply(player));
        assertEquals("Can't target self with spell", e.getMessage());
    }
}
