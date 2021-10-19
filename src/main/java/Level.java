public class Level {
    private int currentLevel;
    private int shownPlayerXP;
    private int xpToNextLevel;
    private final int MAX_LEVEL = 100;
    private final double XP_INCREMENT = 1.5;

    public Level(int level){
        setCurrentLevel(level);
    }

    public void addXP(int XP){
        shownPlayerXP += XP;
        while (shownPlayerXP >= xpToNextLevel && currentLevel < MAX_LEVEL) {
            currentLevel++;
            shownPlayerXP = shownPlayerXP - xpToNextLevel;
            xpToNextLevel *= XP_INCREMENT;
        }
    }

    public int getCurrentLevel(){
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel){
        this.currentLevel = currentLevel;
        shownPlayerXP = 0;
        xpToNextLevel = 100;
        for (int i = 1; i < currentLevel; i++) {
            xpToNextLevel *= 1.5;
        }
    }

    public int getShownPlayerXP(){
        return shownPlayerXP;
    }
}
