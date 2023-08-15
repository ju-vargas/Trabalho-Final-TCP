package src.test.com.game.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import src.com.game.model.Player;
import src.com.game.model.PowerUp;

public class PowerUpTest {

    /*@Test
    public void testApplyEffect() {
        Player player = new Player('C');
        PowerUp.applyEffect(player);
        assertEquals(speedValue, player.getSpeed());
        assertNotNull(player.getEndSpeedUpTime());
    }*/
    
    @Test
    public void testMoveUp() {
        Player player = new Player('C');
        player.moveUp();
        assertEquals('C', player.getDirection());
    }

    @Test
    public void testMoveDown() {
        Player player = new Player('C');
        player.moveDown();
        assertEquals('B', player.getDirection());
    }

    @Test
    public void testMoveRight() {
        Player player = new Player('C');
        player.moveRight();
        assertEquals('D', player.getDirection());
    }

    @Test
    public void testMoveLeft() {
        Player player = new Player('C');
        player.moveLeft();
        assertEquals('E', player.getDirection());
    }

}
