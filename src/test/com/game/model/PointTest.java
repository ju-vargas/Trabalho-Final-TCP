package src.test.com.game.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


import src.com.game.model.Player;
import src.com.game.model.Point;

public class PointTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player('C'); // You can adjust the initial direction as needed
    }

    @Test
    public void testApplyEffect() {
        int originalPoints = player.getPoints();
        int originalSize = player.getSize();

        Point point = new Point(new int[]{0, 0}, 10, "image.png");
        Point.applyEffect(player); // Access the static method in a static way

        int newPoints = player.getPoints();
        int newSize = player.getSize();

        assertEquals(originalPoints + 10, newPoints);
        assertEquals(originalSize + 1, newSize);
    }
}






