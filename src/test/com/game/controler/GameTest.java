package src.test.com.game.controler;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

import src.com.game.view.GameScreen;

public class GameTest {

    private GameScreen gameScreen;

    @Before
    public void setUp() {
        gameScreen = new GameScreen();
    }

    @Test
    public void testInitNewGame() {
        String id = "1";

        gameScreen.initNewGame(id);
        assertNotNull(gameScreen); // Make sure gameScreen is initialized
    }

}
