public class Turn {
    public Turn (Action a1, Entity e1, Entity e2){
        a1.use(e1, e2);
    }
}
