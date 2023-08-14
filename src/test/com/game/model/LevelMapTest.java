package src.test.com.game.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertArrayEquals;

import src.com.game.controler.Jogo;
import src.com.game.model.LevelMap;
import src.com.game.view.GameScreen;

public class LevelMapTest {

    private LevelMap levelMap;

    @Before
    public void setUp() {
        try {
            levelMap = new LevelMap("1", Jogo.PATH_LEVEL1);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to set up LevelMap");
        }
    }
    
    @Test
    public void testGetPointCoordinates() {
        int[] pointCoordinates = levelMap.getPointCoordinates();
        assertNotNull("Point coordinates are not null", pointCoordinates);
        assertEquals("Point X coordinate is within bounds", true, pointCoordinates[0] >= 0 && pointCoordinates[0] < Jogo.XBlocks);
        assertEquals("Point Y coordinate is within bounds", true, pointCoordinates[1] >= 0 && pointCoordinates[1] < Jogo.YBlocks);
    }

    @Test
    public void testGetPowerUpCoordinates() {
        int[] powerUpCoordinates = levelMap.getPowerUpCoordinates();
        assertNotNull("Power-up coordinates are not null", powerUpCoordinates);
        assertEquals("Power-up X coordinate is within bounds", true, powerUpCoordinates[0] >= 0 && powerUpCoordinates[0] < Jogo.XBlocks);
        assertEquals("Power-up Y coordinate is within bounds", true, powerUpCoordinates[1] >= 0 && powerUpCoordinates[1] < Jogo.YBlocks);
    }
}
