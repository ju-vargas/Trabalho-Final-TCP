package src.test.com.game.controler;
import src.com.game.controler.LevelProgress;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LevelProgressTest {
      
    @Test
    public void testConstructor() {
        
        int id = 1;
        boolean isCompleted = true;
        boolean isRunning = false;
        int time = 120;

        LevelProgress progress = new LevelProgress(id, isCompleted, isRunning, time);

        assertEquals(id, progress.getId());
        assertEquals(isCompleted, progress.isCompleted());
        assertEquals(isRunning, progress.isRunning());
        assertEquals(time, progress.getTime());
    }
}