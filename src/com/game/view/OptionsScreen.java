package src.com.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Game;
import src.com.game.controler.SaveLevel;
import src.com.game.model.Level;
import src.com.game.model.Screen;
import src.com.game.controler.GameProgress;


import src.com.game.utils.style.Fonts;

public class OptionsScreen extends Screen {    
    public OptionsScreen() {    
        super();
        setLocationRelativeTo(null);
        Fonts styles = new Fonts();

		setLayout(new GridBagLayout());
		GridBagConstraints mainConstraints = new GridBagConstraints();

        JLabel labelTitle = new JLabel("DOGBYTE");
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(styles.boldTitle());
        labelTitle.setBounds(180, 100, 900, 200);
		
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 0;
        add(labelTitle, mainConstraints);


        // Botões na parte inferior
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton newGameButton = new JButton("Novo Jogo");
		newGameButton.setFont(styles.boldButton());
        JButton continueButton = new JButton("Continuar");
		continueButton.setFont(styles.boldButton());
        JButton rankingButton = new JButton("Ranking");
		rankingButton.setFont(styles.boldButton());
        JButton rulesButton = new JButton("Regras");
		rulesButton.setFont(styles.boldButton());
		JButton exitButton = new JButton("Sair");
		exitButton.setFont(styles.boldButton());

        buttonsPanel.add(newGameButton);
        buttonsPanel.add(continueButton);
        buttonsPanel.add(rankingButton);
        buttonsPanel.add(rulesButton);
		buttonsPanel.add(exitButton);
        
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 1;
		
        add(buttonsPanel,mainConstraints);

      
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //NOVO JOGO limpa todo o progresso

                GameProgress.clearGameProgress(1);
                GameProgress.clearGameProgress(2);
                
                Level level1 = new Level("1",2,3,Game.PATH_LEVEL1);
                SaveLevel.saveLevel(level1,"1");
                Level level2 = new Level("2",2,3,Game.PATH_LEVEL2);
                SaveLevel.saveLevel(level2,"2");
                
                GameProgress.printGameProgress();


                //E ai vai pro jogo
                Game.mapaScreen.update();
                goTo(Game.introductionScreen);
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.mapaScreen.update();
                goTo(Game.mapaScreen);
            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Game.rankingScreen);
            }
        });
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                goTo(Game.rulesScreen);
            }
        });
		exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            };
        });
    }

  

}

