package src.test.com.game.model;

import org.junit.Test;
import static org.junit.Assert.*;

import src.com.game.view.OptionsScreen;

public class ScreenTest {

    @Test
    public void testTelaCreation() {
        
        OptionsScreen tela = new OptionsScreen();
        assertNotNull(tela);
    }
}