public class Air implements Element {
    @Override
    public double getModifierAgainst(Element element) {
        if (element == null)
            throw new IllegalArgumentException("Argument can not be null!");
        else if (element instanceof Fire)
            return 0.5;
        else if (element instanceof Water)
            return 1;
        else if (element instanceof Air)
            return 1;
        else if (element instanceof Earth)
            return 1.5;
        else
            throw new IllegalStateException("This element does not exist in the magic system!");
    }
}
