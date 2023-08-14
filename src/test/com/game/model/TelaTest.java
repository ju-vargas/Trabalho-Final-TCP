package src.test.com.game.model;

import org.junit.Test;
import static org.junit.Assert.*;

import src.com.game.model.Tela;

public class TelaTest {

    @Test
    public void testTelaCreation() {
        
        Tela tela = new Tela();
        assertNotNull(tela);
    }
}