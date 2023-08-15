package src.com.game.controler;

import javax.swing.*;
import java.awt.*;

import src.com.game.view.*;


public class Game {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
    public static final int HEADER_SIZE = 60;

    public static final int BLOCK_SIZE = 30;
    public static final int UNITS = WIDTH * HEIGHT / (BLOCK_SIZE * BLOCK_SIZE);
    public static final int X_BLOCKS = (int) 1260 / BLOCK_SIZE; //tamanho máximo de blocos no grid no eixo x
    public static final int Y_BLOCKS = (int) 650 / BLOCK_SIZE; //tamanho máximo de blocos no grid no eixo x

    public static final int EMPTY_BLOCK_ID = 0;
    public static final int OBSTACLE_ID = 1;
    public static final int POINT_ID = 2;
    public static final int POWERUP_ID = 3;

    public static final int INICIAL_PLAYER_SIZE = 6;
    public static final int STANDART_INTERVAL = 60;

    /*
     * criar uma classe depois so pra ter os paths certinhos!!
     * por enquanto eh gambiarra
     */
    public static String PATH_LEVEL1 = "resources/maps/source/1.txt";
    public static String PATH_LEVEL2 = "resources/maps/source/2.txt";

    public static OptionsScreen optionsScreen = new OptionsScreen();
    public static GameScreen gameScreen = new GameScreen();
    public static RankingScreen rankingScreen = new RankingScreen();
    public static RulesScreen rulesScreen = new RulesScreen();
    public static MapScreen mapaScreen = new MapScreen();
    public static IntroductionScreen introductionScreen = new IntroductionScreen();
    public static WinScreen winScreen = new WinScreen();
    public static FaseIntroduction faseIntroduction = new FaseIntroduction("1");
    public static DeadScreen deadScreen = new DeadScreen();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OptionsScreen frame = new OptionsScreen();
            frame.setVisible(true);
        });
    }

    public static void initNewGame(String id){
        gameScreen.initNewGame(id);
    }
}