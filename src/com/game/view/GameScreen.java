package src.com.game.view;

import src.com.game.controler.Game;
import src.com.game.model.Screen;

public class GameScreen extends Screen {
    GameView gameView = new GameView();

    public GameScreen() {
        super();
        add(gameView);
        setTitle("Jogo da Cobrinha - Snake game");
    }

    public void initNewGame(String id){

        gameView.startGameLevel(id);
    }

    public void changeScreenLevel(){
        Game.mapaScreen.update();
        goTo(Game.mapaScreen);
    }

    public void changeScreenWin(){
        goTo(Game.winScreen);
    }

    public void changeScreenDead(){
        goTo(Game.deadScreen);
    }

}
