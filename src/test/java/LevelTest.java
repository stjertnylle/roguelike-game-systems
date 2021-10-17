import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LevelTest {

    @Test
    void currentLevelIsSetCorrectly(){
        Level levelOne = new Level(1);
        assertEquals(1, levelOne.getCurrentLevel());
    }
    @Test
    void levelIsNotIncreasedWhenAddingInsufficientXP(){
        Level levelOne = new Level(1);
        levelOne.addXP(99);
        assertEquals(1, levelOne.getCurrentLevel());
    }

    @Test
    void levelIsIncreasedWhenAddingSufficientXP(){
        Level levelOne = new Level(1);
        levelOne.addXP(101);
        assertEquals(2, levelOne.getCurrentLevel());
    }
}
