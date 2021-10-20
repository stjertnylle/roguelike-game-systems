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
    };

    Vampire vampire = new Vampire(10);
    Orc orc = new Orc(10);


    @Test
    void testLightAttack() {
        player.setWeapon(new SwiftAxe());
        LightAttack la = new LightAttack(player);
        la.apply(vampire);
        assertEquals(90, vampire.getCurrentHP());
        assertEquals(10.5, la.getSpeed());
    }

    @Test
    void targetSelfLightAttack() {
        LightAttack la = new LightAttack(player);
        player.setWeapon(new SwiftAxe());
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> la.apply(player));
        assertEquals("Can't target self with attack", e.getMessage());
    }

    @Test
    void testLightAttackNoWeapon(){
        LightAttack la = new LightAttack(player);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> la.apply(vampire));
        assertEquals("Can't attack without weapon equipped", e.getMessage());
    }

    @Test
    void testHeavyAttackVampire(){
        player.setWeapon(new SwiftAxe());
        HeavyAttack ha = new HeavyAttack(player);
        ha.apply(vampire);
        assertEquals(85, vampire.getCurrentHP());
        assertEquals(7.5, ha.getSpeed());
    }

    @Test
    void testHeavyAttackPlayer(){
        HeavyAttack ha = new HeavyAttack(orc);
        ha.apply(player);
        assertEquals(49, player.getCurrentHP());
    }

    @Test
    void testHeavyAttackOrc(){
        player.setWeapon(new DoubleAxe());
        HeavyAttack ha = new HeavyAttack(player);
        ha.apply(orc);
        assertEquals(49, orc.getCurrentHP());
    }

    @Test
    void testHeavyAttackNoWeapon(){
        HeavyAttack ha = new HeavyAttack(player);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> ha.apply(orc));
        assertEquals("Can't attack without weapon equipped", e.getMessage());
    }

    @Test
    void targetSelfHeavyAttack() {
        HeavyAttack ha = new HeavyAttack(player);
        player.setWeapon(new SwiftAxe());
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ha.apply(player));
        assertEquals("Can't target self with attack", e.getMessage());
    }

    @Test
    void testFireStrikeVampire(){
        FireStrike fs = new FireStrike(player);
        player.equipWeapon(new SwiftAxe());
        fs.apply(vampire);
        assertEquals(55, vampire.getCurrentHP());
        assertEquals(70, player.getCurrentMana());
        assertEquals(7.5, fs.getSpeed());
    }

    @Test
    void testFireStrikeOrc(){
        FireStrike fs = new FireStrike(player);
        fs.apply(orc);
        assertEquals(70, orc.getCurrentHP());
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
        assertEquals(6, hs.getSpeed());
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
        player.equipWeapon(new SwiftAxe());
        assertEquals(80, vampire.getCurrentHP());
        assertEquals(80, player.getCurrentMana());
        assertEquals(12, ws.getSpeed());
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
