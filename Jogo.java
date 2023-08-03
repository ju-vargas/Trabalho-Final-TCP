import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;
    public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

    public static final String TELA_UM = "1";
    public static final String TELA_DOIS = "2";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Troca de Tela Exemplo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            /**
             * TELAS DISPONÍVEIS
             */
            TelaUm telaum = new TelaUm();
            cardPanel.add(telaum, TELA_UM);
            TelaDois teladois = new TelaDois();
            cardPanel.add(teladois, TELA_DOIS);

            frame.add(cardPanel);
            frame.setVisible(true);
        });
    }
}