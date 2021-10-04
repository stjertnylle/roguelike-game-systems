public interface Monster {
    int getLevel();

    int getExpReward();

    Action getAction();

    Element getElement();

    int getHPValue();

    void decreaseHP(int amount);

    void increaseHP(int amount);

    int getManaValue();

    void decreaseMana(int amount);

    void increaseMana(int amount);

    void consumePotion(Potion potion);

}
