package src.com.game.controler;

import src.com.game.view.TelaJogo;

import javax.swing.*;
import java.awt.*;

import src.com.game.view.FirstScreen;
import src.com.game.view.SecondScreen;
import src.com.game.view.IntroductionScreen;
import src.com.game.view.RulesScreen;
import src.com.game.view.WinScreen;
import src.com.game.utils.MapConstraints;


public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

    public static final String FIRST_SCREEN = "1";
    public static final String SECOND_SCREEN = "2";
    public static final String INTRODUCTION_SCREEN = "3";
    public static final String RULES_SCREEN = "4";
    public static final String WIN_SCREEN = "5";


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
            WinScreen winScreen = new WinScreen();
            cardPanel.add(winScreen, WIN_SCREEN);
            RulesScreen rulesScreen = new RulesScreen();
            cardPanel.add(rulesScreen, RULES_SCREEN);
            IntroductionScreen introductionScreen = new IntroductionScreen();
            cardPanel.add(introductionScreen, INTRODUCTION_SCREEN);
            FirstScreen firstScreen = new FirstScreen();
            cardPanel.add(firstScreen, FIRST_SCREEN);
            SecondScreen secondScreen = new SecondScreen();
            cardPanel.add(secondScreen, SECOND_SCREEN);

            frame.add(cardPanel);
            frame.setVisible(true);

        });
    }
}