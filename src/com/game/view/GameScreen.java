package src.com.game.view;

import javax.swing.*;

public class GameScreen extends JFrame {
    public static void main(String[] args) {
        new GameScreen();
    }

    public GameScreen() {
        add(new GameView());
        setTitle("Jogo da Cobrinha - Snake game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setResizable(false);
        // pack();
        // setVisible(true);
        // setLocationRelativeTo(null);
    }
}
