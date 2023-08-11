package src.com.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Tela;
import src.com.game.utils.style.Fonts;

public class OptionsScreen extends Tela {

    public OptionsScreen() {    

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
                Jogo.cardLayout.show(Jogo.cardPanel, Jogo.GAME_SCREEN);
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jogo.cardLayout.show(Jogo.cardPanel, Jogo.GAME_SCREEN);
            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jogo.cardLayout.show(Jogo.cardPanel, Jogo.RANKING_SCREEN);
            }
        });
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Jogo.cardLayout.show(Jogo.cardPanel, Jogo.RULES_SCREEN);
            }
        });
		exitButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		};


	});

		

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OptionsScreen tela = new OptionsScreen();
            tela.setVisible(true);
        });
    }
}

