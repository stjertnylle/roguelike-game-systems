public interface MonsterInterface {
    int getLevel();

    int getExpReward();

    Action getAction();

    Element getElement();

    int getCurrentHP();

    int getMaxHP();

    void setHP(int value);

    void decreaseHP(int amount);

    void increaseHP(int amount);

    int getCurrentMana();

    int getMaxMana();

    void setMana(int value);

    void decreaseMana(int amount);

    void increaseMana(int amount);

    void consumePotion(Potion potion);

}
