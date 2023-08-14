package src.com.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Tela;

import src.com.game.utils.style.Fonts;

public class RootScreen extends Tela {    
    public RootScreen() {    
        super();
        setLocationRelativeTo(null);
        Fonts styles = new Fonts();

		setLayout(new GridBagLayout());
		GridBagConstraints mainConstraints = new GridBagConstraints();



        JLabel labelTitle = new JLabel("ROOT");
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(styles.boldTitle());
        labelTitle.setBounds(180, 100, 900, 200);
		
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 0;
        add(labelTitle, mainConstraints);


        // Botões na parte inferior
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton introductionButton = new JButton("Introdução");
		introductionButton.setFont(styles.boldButton());
        JButton winButton = new JButton("Vencer jogo");
		winButton.setFont(styles.boldButton());
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
        JButton menuOptions = new JButton("Opções");
		menuOptions.setFont(styles.boldButton());

		buttonsPanel.add(introductionButton);
        buttonsPanel.add(winButton);
        buttonsPanel.add(newGameButton);
        buttonsPanel.add(continueButton);
        buttonsPanel.add(rankingButton);
        buttonsPanel.add(rulesButton);
		buttonsPanel.add(exitButton);
        buttonsPanel.add(menuOptions);
        
		mainConstraints.gridx = 0;
		mainConstraints.gridy = 1;
		
        add(buttonsPanel,mainConstraints);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.gameScreen);
                //Jogo.initNewGame("");
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.gameScreen);
            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.rankingScreen);
            }
        });
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                goTo(Jogo.rulesScreen);
            }
        });
        introductionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.introductionScreen);
            };
        });
        winButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.winScreen);
            };
        });
		exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            };
        });
        menuOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.optionsScreen);
            }
        });
    }
}

