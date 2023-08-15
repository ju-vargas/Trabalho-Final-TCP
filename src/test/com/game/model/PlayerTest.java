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
    private int[][] mockMap = new int[Jogo.XBlocks][Jogo.YBlocks];

    @Before
    public void setUp() {
        player = new Player('C');
        mockLevel = new Level("1", 2, 3, "resources/maps/source/1.txt");
    }

    @Test
    public void testNoCollision() {
        // Test when there is no collision
        //System.out.println(player.getPoints());
        
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
