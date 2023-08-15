package src.test.com.game.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import src.com.game.model.LevelMap;
import src.com.game.model.PowerUp;

public class LevelMapTest {

    private LevelMap levelMap;
    private PowerUp pw;

    @Before
    public void setUp() {
    
        int[][] initialMapConstraints = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        levelMap = new LevelMap("1", "resources/maps/source/1.txt");
        levelMap.setMapConstraints(initialMapConstraints);

        pw = new PowerUp(new int[]{1, 1}, 1, 2, null);
    }

    @Test
    public void testRemoveObject() {
        int[] coord = {1, 1}; 

        levelMap.removeObject(coord, pw);

        int[][] expectedMapConstraints = {
                {1, 2, 3},
                {4, 0, 6}, 
                {7, 8, 9}
        };

        int[][] actualMapConstraints = levelMap.getMapConstraints();
        assertArrayEquals(expectedMapConstraints, actualMapConstraints);
    }

    // Utilidade para comparar matrizes
    private void assertArrayEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
