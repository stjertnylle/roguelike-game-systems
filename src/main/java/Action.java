public interface Action {
    String getName();

    double getSpeed();

    void use(Entity user, Entity receiver);

}
