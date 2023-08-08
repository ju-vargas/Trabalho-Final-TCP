//package src.com.game.controler;

import javax.swing.*;
import java.awt.*;

public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
    public static int BAR_HEIGHT;
    public static final String TRUE_GAME_SCREEN = "TG";
    public static final String SECOND_SCREEN = "2";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Troca de Tela Exemplo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.setVisible(true);

            //frame.setResizable(false);
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);
            
            /**
             * AVALIABLE SCREENS
             */           
            BAR_HEIGHT = frame.getInsets().top;
            System.out.println("Tamanho estimado da barra de título: " + BAR_HEIGHT + " pixels");
            
            TelaJogo trueGameScreen = new TelaJogo();
            cardPanel.add(trueGameScreen, TRUE_GAME_SCREEN);
            
            frame.add(cardPanel);
        });
    }
}