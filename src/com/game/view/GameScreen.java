package src.com.game.view;
import src.com.game.model.Tela;

public class GameScreen extends Tela {
    GameView gameView = new GameView();

    public GameScreen() {
        super();
        add(gameView);
        setTitle("Jogo da Cobrinha - Snake game");
    }

    public void initNewGame(String id){
        gameView.startGameLevel(id);
    }
}
