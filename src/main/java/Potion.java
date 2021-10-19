public abstract class Potion{
    private String type;
    private int value;

    public Potion(String type, int value){
        this.type = type;
        this.value = value;
    }

    public void usePotion(Player player){
        if(!(player.getPotionInventory().contains(this))){
            throw new IllegalArgumentException("Potion not in potion inventory");
        }
        if(this.getType().equals("Health")){
            if(player.getCurrentHP() == player.getMaxHP()){
                throw new IllegalStateException("Player HP already full");
            }
            player.increaseHP(this.getValue());
        }else if(this.getType().equals("Mana")){
            if(player.getCurrentMana() == player.getMaxMana()){
                throw new IllegalStateException("Player mana already full");
            }
            player.increaseMana(this.getValue());
        }
    }

    public String getType() {
        return type;
    }

    public int getValue(){
        return value;
    }
}
