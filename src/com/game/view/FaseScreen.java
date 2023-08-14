package src.com.game.view;
import javax.swing.*;
import java.awt.*;

import src.com.game.model.Fase;
import src.com.game.model.Screen; 

public class FaseScreen extends Screen {
    
    private Fase currentFase;

	private final int WIDTH = 800;
	private final int HEIGHT = 600;

    public FaseScreen(Fase fase) {
        this.currentFase = fase;
    }

    public Fase getFaseAtual() {
        return currentFase;
    }

    public void setFaseAtual(Fase currentFase) {
        this.currentFase = currentFase;
    }
    
    // Se você quiser criar uma tela de vitória, pode fazer isso como um método separado
    public void showWinScreen() {
	
		JLabel winText = new JLabel("Parabéns, você passou de Fase!");
        winText.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton continueButton = createFaseButton("Continuar");
        JButton mapButton = createFaseButton("Mapa");

        JPanel panel = createPanel();
		panel.add(winText);

        GridBagConstraints buttonPosition = new GridBagConstraints();
        buttonPosition.gridy = 1; // Define the continue button below the text
        panel.add(continueButton, buttonPosition);
        buttonPosition.gridx = 1; // Define the map button next to the continue button
        panel.add(mapButton, buttonPosition);

        JFrame window = configureWindow();
        window.add(panel);
        window.setVisible(true);
        
    }

	public void showDeathScreen() {

        JLabel deathText = new JLabel("Você Morreu :(");
		JButton tryAgainButton = createFaseButton("Tentar Novamente");
        JButton mapButton = createFaseButton("Mapa");

        JPanel panel = createPanel();
		panel.add(deathText);

        GridBagConstraints buttonsPosition = new GridBagConstraints();
        buttonsPosition.gridy = 1; // Define the continue button below the text
        panel.add(tryAgainButton, buttonsPosition);
        buttonsPosition.gridx = 1; // Define the map button next to the continue button
        panel.add(mapButton, buttonsPosition);
        
        JFrame window = configureWindow();
		window.add(panel);
        window.setVisible(true);
	}

	public void showIntroductionScreen() {
        JLabel introductionText = new JLabel(introductionText());
		JButton continueButton = createFaseButton("Continuar");

        JPanel panel = createPanel();
		panel.add(introductionText);
        
        GridBagConstraints buttonPosition = new GridBagConstraints();
        buttonPosition.gridy = 1; // Define the continue button below the text
        panel.add(continueButton, buttonPosition);

        JFrame window = configureWindow();
		window.add(panel);
        window.setVisible(true);
	}

    //tem como quebrar essa linha aqui?
    public String introductionText(){
        return "<html>O semestre foi difícil... pela terceira vez<br>Mas espere! O professor esqueceu de considerar<br>uma questão da prova<br>Encontre o professor para rever a sua nota e quebrar a maldição</html>";
    }

	public JFrame configureWindow() {
        JFrame window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return window;
	}

	public JButton createFaseButton(String buttonText){
		JButton button = new JButton();
        button.add(new JButton(buttonText));
		return button;
	}

    public JPanel createPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(new GridBagLayout());

        return panel;
    }
}
