package src.test.com.game.model;

import src.com.game.controler.Game;
import src.com.game.model.Player;

import static org.junit.Assert.assertFalse;

import src.com.game.model.Level;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private Level mockLevel;
    private int[][] mockMap = new int[Game.X_BLOCKS][Game.Y_BLOCKS];

    @Before
    public void setUp() {
        player = new Player('C');
        mockLevel = new Level("1", 2, 3, "resources/maps/source/1.txt");
    }

    @Test
    public void testNoCollision() {
        // Test when there is no collision
        
        boolean result = player.checkCollision(mockMap, mockLevel);
        System.out.println("result" + result);
        assertFalse("Resultado:"+ result, result); // Expecting no collision
    }

    public static void main(String[] args) {
        //Player playerTest;
        //playerTest = new Player('C');
        //playerTest.testNoCollision();
        //System.out.println("Player speed: " + playerTest.getSpeed());
    }

}
