public abstract class Potion implements Item {
    private String type;
    private int value;

    public Potion(String type, int value){
        this.type = type;
        this.value = value;
    }

    public abstract void usePotion(Player player);

    public String getType() {
        return type;
    }

    public int getValue(){
        return value;
    }
}
