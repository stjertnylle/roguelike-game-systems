public interface Action {
    String getName();

    int getSpeed();

    void use(Entity user, Entity receiver);

}
