public class Level {
    private int currentLevel;
    private int actualPlayerXP;
    private int shownPlayerXP;
    private int xpToNextLevel;
    private final int MAX_LEVEL = 100;

    public Level(int level){
        this.currentLevel = level;
        shownPlayerXP = 0;
        actualPlayerXP = 0;
        xpToNextLevel = 100;
    }

    public void addXP(int XP){
        actualPlayerXP += XP;
        shownPlayerXP += XP;
        if (shownPlayerXP >= xpToNextLevel && currentLevel < MAX_LEVEL){
            currentLevel ++;
            shownPlayerXP =  shownPlayerXP - xpToNextLevel;
            xpToNextLevel *= 1.5;
        }
    }

    public int getCurrentLevel(){
        return currentLevel;
    }
}
