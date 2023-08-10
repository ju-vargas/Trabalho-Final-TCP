package src.com.game.controler;

import javax.swing.*;
import src.com.game.view.FirstScreen;
import src.com.game.view.SecondScreen;

import java.awt.*;

public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

    public static final String FIRST_SCREEN = "1";
    public static final String SECOND_SCREEN = "2";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Troca de Tela Exemplo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            /**
             * AVALIABLE SCREENS
             */
            FirstScreen firstScreen = new FirstScreen();
            cardPanel.add(firstScreen, FIRST_SCREEN);
            SecondScreen secondScreen = new SecondScreen();
            cardPanel.add(secondScreen, SECOND_SCREEN);

            frame.add(cardPanel);
            frame.setVisible(true);
        });
    }
}