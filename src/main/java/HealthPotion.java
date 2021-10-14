public class HealthPotion extends Potion {
    public HealthPotion() {
        super("Health", 50);
    }

    @Override
    public void usePotion(Player player) {
        player.increaseHP(getValue());
    }
}
