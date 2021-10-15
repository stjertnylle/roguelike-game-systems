public class HealthPotion extends Potion {
    public HealthPotion() {
        super("Health", 50);
    }

    @Override
    public void usePotion(PlayerInterface player) {
        player.increaseHP(getValue());
    }
}
