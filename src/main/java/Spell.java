public interface Spell extends Item {
    Element getElement();

    int getManaCost();

    int getDamageValue();
}
