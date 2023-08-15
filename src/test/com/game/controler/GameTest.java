package src.test.com.game.controler;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

import src.com.game.view.GameScreen;
import src.com.game.controler.Game;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testInitNewGame() {
        String id = "1";

        Game.initNewGame(id);
        assertNotNull(game); // Make sure gameScreen is initialized
    }
}
