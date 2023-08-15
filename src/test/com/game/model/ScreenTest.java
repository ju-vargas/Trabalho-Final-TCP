package src.test.com.game.model;

import org.junit.Test;
import static org.junit.Assert.*;

import src.com.game.model.Screen;

public class ScreenTest {

    @Test
    public void testTelaCreation() {
        
        Screen tela = new Screen();
        assertNotNull(tela);
    }
}