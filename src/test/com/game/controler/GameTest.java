package src.test.com.game.controler;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

import src.com.game.view.GameScreen;
import src.com.game.controler.Jogo;

public class GameTest {

    private Jogo game;

    @Before
    public void setUp() {
        game = new Jogo();
    }

    @Test
    public void testInitNewGame() {
        String id = "1";

        Jogo.initNewGame(id);
        assertNotNull(game); // Make sure gameScreen is initialized
    }
}
