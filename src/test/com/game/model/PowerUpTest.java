package src.test.com.game.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;

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

    Player player;

    @Before
    public void setUp(){
        player = new Player('C');
    }
    
    @Test
    public void testApplyEffect(){

        double originalSpeed = player.getSpeed();
        double speedValue = 3;
        double speedPoweredUp = originalSpeed + speedValue;
        int speedUpDuration = 3;

        int[] coord = {4, 2};
        PowerUp pw = new PowerUp(coord, speedValue, speedUpDuration, "image.jp");
        
        PowerUp.applyEffect(player);

        double playerSpeedUp = ;

        //player.speedUp(3.0);
        assertEquals(speedPoweredUp, player.getSpeed());
    }
}
