package src.test.com.game.model;

import src.com.game.controler.Jogo;
import src.com.game.model.Player;

import static org.junit.Assert.assertFalse;

import src.com.game.model.Level;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;
    private Level mockLevel;
    private int[][] mockMap;

    @Before
    public void setUp() {
        player = new Player('C'); // You can set the initial direction as needed
        mockLevel = new Level("1", 2, 3, Jogo.PATH_LEVEL1); // You might need to adjust this based on your Level class
        mockMap = new int[Jogo.XBlocks][Jogo.YBlocks];
    }

    @Test
    public void testNoCollision() {
        // Test when there is no collision
        boolean result = player.checkCollision(mockMap, mockLevel);
        assertFalse(result); // Expecting no collision
    }

}
