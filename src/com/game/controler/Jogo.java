package src.com.game.controler;

import javax.swing.*;
import java.awt.*;

import src.com.game.utils.MapConstraints;


import src.com.game.view.OptionsScreen;
import src.com.game.view.IntroductionScreen;
import src.com.game.view.RulesScreen;
import src.com.game.view.MapaScreen;
import src.com.game.view.GameScreen;
import src.com.game.view.FaseScreen;
import src.com.game.view.WinScreen;
import src.com.game.view.RankingScreen;
import src.com.game.view.FirstScreen;
import src.com.game.view.SecondScreen;


public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
    public static int WINDOW_HEIGHT_DIFFERENCE;
    public static int WINDOW_WIDTH_DIFFERENCE;
    public static final String TRUE_GAME_SCREEN = "TG";



    /*
    * CONSTANTS SCREENS 
    */
    
    public static final String OPTIONS_SCREEN = "1";
    public static final String INTRODUCTION_SCREEN = "2";
    public static final String MAP_SCREEN = "3";
    public static final String GAME_SCREEN = "4";
    public static final String WIN_SCREEN = "5";
    public static final String RANKING_SCREEN = "6";
    public static final String RULES_SCREEN = "7";
    
    public static final String FIRST_SCREEN = "8";
    public static final String SECOND_SCREEN = "9";
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dog Byte");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            /**
             * AVALIABLE SCREENS
             */

            OptionsScreen optionsScreen = new OptionsScreen();
            cardPanel.add(optionsScreen, WIN_SCREEN);
            IntroductionScreen introductionScreen = new IntroductionScreen();
            cardPanel.add(introductionScreen, INTRODUCTION_SCREEN);
            MapaScreen mapaScreen = new MapaScreen();
            cardPanel.add(mapaScreen, MAP_SCREEN);
            GameScreen gameScreen = new GameScreen();
            cardPanel.add(gameScreen, GAME_SCREEN);
            WinScreen winScreen = new WinScreen();
            cardPanel.add(winScreen, WIN_SCREEN);
            RankingScreen rankingScreen = new RankingScreen();
            cardPanel.add(rankingScreen, RANKING_SCREEN);
            RulesScreen rulesScreen = new RulesScreen();
            cardPanel.add(rulesScreen, RULES_SCREEN);
            FirstScreen firstScreen = new FirstScreen();
            cardPanel.add(firstScreen, FIRST_SCREEN);
            SecondScreen secondScreen = new SecondScreen();
            cardPanel.add(secondScreen, SECOND_SCREEN);


            WINDOW_HEIGHT_DIFFERENCE = frame.getInsets().top + frame.getInsets().bottom;
            WINDOW_WIDTH_DIFFERENCE = frame.getInsets().left + frame.getInsets().right;  
          
            frame.add(cardPanel);
            frame.setVisible(true);

        });
    }
}