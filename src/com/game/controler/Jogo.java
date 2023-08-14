package src.com.game.controler;

import javax.swing.*;
import java.awt.*;


import src.com.game.view.OptionsScreen;
import src.com.game.view.IntroductionScreen;
import src.com.game.view.RulesScreen;
import src.com.game.view.WinScreen;
import src.com.game.view.MapaScreen;
import src.com.game.view.GameScreen;
import src.com.game.view.RankingScreen;
import src.com.game.view.RootScreen;


public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
    public static final int HEADER_SIZE = 60;
    public static int WINDOW_HEIGHT_DIFFERENCE;
    public static int WINDOW_WIDTH_DIFFERENCE;
    public static int MAX_HEIGHT = HEIGHT - WINDOW_HEIGHT_DIFFERENCE;
    public static int MAX_WIDTH = WIDTH - WINDOW_WIDTH_DIFFERENCE;

    public static int BLOCK_SIZE = 20;
    public static int UNITS = WIDTH * HEIGHT / (BLOCK_SIZE * BLOCK_SIZE);
    public static int XBlocks = 63; //tamanho máximo de blocos no grid no eixo x
    public static int YBlocks = 31; //tamanho máximo de blocos no grid no eixo x

    public static int INICIAL_PLAYER_SIZE = 6;



    /*
     * criar uma classe depois so pra ter os paths certinhos!!
     * por enquanto eh gambiarra
     */

    public static String PATH_LEVEL1 = "resources/maps/source/1.txt";

    public static boolean isGameRunning = false;

    public static OptionsScreen optionsScreen = new OptionsScreen();
    public static GameScreen gameScreen = new GameScreen();
    public static RankingScreen rankingScreen = new RankingScreen();
    public static RulesScreen rulesScreen = new RulesScreen();
    public static MapaScreen mapaScreen = new MapaScreen();
    public static IntroductionScreen introductionScreen = new IntroductionScreen();
    public static WinScreen winScreen = new WinScreen();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RootScreen frame = new RootScreen();
            frame.setVisible(true);
        });
    }

    public static void initNewGame(){
        gameScreen.initNewGame();
    }
}