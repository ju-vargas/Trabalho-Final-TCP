package src.com.game.view;
import src.com.game.model.Tela;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.com.game.utils.style.*;
import src.com.game.controler.LevelProgress;
import src.com.game.controler.GameProgress;
import src.com.game.controler.Jogo;

public class MapScreen extends Tela {

	public MapScreen(){
        super();
        setLocationRelativeTo(null);

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 150, 0, 150);	
		
        GameProgress gameProgress = new GameProgress();
        LevelProgress[] loadedProgress = gameProgress.loadGameProgress();

        String[] sprite = new String[3];


        for(int i = 0; i<2; i++){
            if (loadedProgress[i].isCompleted() == true){
                sprite[i] = "completebutton";
            }
            else if(loadedProgress[i].isRunning() == true){
                sprite[i] = "almostbutton"; 
            }
            else
                sprite[i] = "notbutton";
        }
        if(loadedProgress[0].isCompleted() & loadedProgress[1].isCompleted())
            sprite[2] = "completebutton";
        else   
            sprite[2] = "notbutton";
    

		JButton button1 = createCircularButton("Fase 1", sprite[0]);
		JButton button2 = createCircularButton("Fase 2", sprite[1]);
		JButton button3 = createCircularButton("Fim",sprite[2]);
	
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(button1, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(button2, constraints);
		constraints.gridx = 2;
		constraints.gridy = 0;
		add(button3, constraints);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loadedProgress[0].isCompleted());
                goTo(Jogo.gameScreen);
                Jogo.initNewGame();
            }
        });

        // Adicionar um ActionListener para tratar o clique no botão
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadedProgress[0].isCompleted()){
                    goTo(Jogo.gameScreen);
                    Jogo.initNewGame();
                } 
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadedProgress[1].isCompleted()){
                    goTo(Jogo.rankingScreen);
                } 
            }
        });
	}

    private static JButton createCircularButton(String label, String type) {
        Images imageFont = new Images();
        Fonts font = new Fonts();

        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(100, 100));
        button.setIcon(new ImageIcon(imageFont.button(type)));

        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setFont(font.boldButton());
        return button;
    }
}
