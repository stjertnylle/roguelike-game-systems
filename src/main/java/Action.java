public interface Action {
    String getName();

    double getSpeed();

    void apply(Entity target);

}
