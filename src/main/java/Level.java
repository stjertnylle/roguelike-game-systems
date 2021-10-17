public class Level {
    private int currentLevel;
    private int actualPlayerXP;
    private int shownPlayerXP;
    private int xpToNextLevel;
    private final int MAX_LEVEL = 100;
    private final double XP_INCREMENT = 1.5;

    public Level(int level){
        this.currentLevel = level;
        shownPlayerXP = 0;
        actualPlayerXP = 0;
        xpToNextLevel = 100;
        for(int i = 1; i < currentLevel; i ++){
            actualPlayerXP += xpToNextLevel;
            xpToNextLevel *= XP_INCREMENT;
        }
    }

    public void addXP(int XP){
        actualPlayerXP += XP;
        shownPlayerXP += XP;
        while (shownPlayerXP >= xpToNextLevel && currentLevel < MAX_LEVEL){
            currentLevel ++;
            shownPlayerXP =  shownPlayerXP - xpToNextLevel;
            xpToNextLevel *= 1.5;
        }
    }

    public int getCurrentLevel(){
        return currentLevel;
    }
}
