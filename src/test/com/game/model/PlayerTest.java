package src.test.com.game.model;

import src.com.game.controler.Game;
import src.com.game.model.Player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private static Player player;
    
    @Before
    public void setUp() {
        player = new Player('D');
    }

    @Test
    public void testCollision() {
        int[] coord = {0,0};
        boolean result = player.hasCollide(coord);
        assertEquals(true,result); // Expecting collision

        coord[0] = 2;
        coord[1] = 3;
        result = player.hasCollide(coord);
        assertEquals(false,result); // Expecting no collision
    }

    @Test
    public void testWalk() {
        for (int i = 0; i < Game.INICIAL_PLAYER_SIZE; i++) {
            player.increaseSize();
        }
        
        player.moveRight();
        player.walk();
        int[] coord = {1,0};
        boolean result = player.hasCollide(coord);
        assertEquals(true,result); // Expecting collision

        player.moveDown();
        player.walk();
        coord[0] = 1;
        coord[1] = 1;
        result = player.hasCollide(coord);
        assertEquals(true,result); // Expecting collision

        player.moveLeft();
        player.walk();
        coord[0] = 0;
        coord[1] = 1;
        result = player.hasCollide(coord);
        assertEquals(true,result); // Expecting collision

        player.moveUp();
        player.walk();
        coord[0] = 0;
        coord[1] = 0;
        result = player.hasCollide(coord);
        assertEquals(true,result); // Expecting collision
    }
}
