import static org.junit.Assert.assertEquals;
import org.junit.Test;

import src.com.game.model.Player;
import src.com.game.model.Point;

public class PointTest {

    @Test
    public void testApplyEffect() {
        Player player = new Player('C'); // Criando um jogador fictício
        int initialValue = player.getPoints();
        int initialSize = player.getSize();

        int pointValue = 10; // Valor do ponto a ser adicionado
        Point point = new Point(new int[]{0, 0}, pointValue, "point_image");

        Point.applyEffect(player);

        // Verificando se os pontos e o tamanho do jogador foram atualizados corretamente
        assertEquals(initialValue + pointValue, player.getPoints());
        assertEquals(initialSize + 1, player.getSize());
    }

    // Adicione mais testes aqui, conforme necessário
}
