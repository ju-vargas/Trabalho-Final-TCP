package src.com.game.view;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class WinScreen extends Screen {
    Fonts configStyle = new Fonts();

    private String[] text = {
        "O aluno finalmente conseguiu chegar ao professor.",
        "Agora você permanecerá como humano!",
        "(Até a próxima cadeira da matemática)",
    };


    public WinScreen() {
        setLayout(new GridBagLayout());
        setBackground(Color.PINK);     
    
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(0,0,0,0));

        GridBagConstraints constraintsMain = new GridBagConstraints();
        constraintsMain.insets = new Insets(10,10,10,10); 

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraintsGrid = new GridBagConstraints();
        gridPanel.setBackground(Color.YELLOW);

        JLabel textIntroduction = new JLabel(text[0]);
        textIntroduction.setFont(configStyle.regularLabel());
        textIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 0;
        gridPanel.add(textIntroduction, constraintsGrid);
    
        JLabel textIntroduction1 = new JLabel(text[1]);
        textIntroduction1.setFont(configStyle.regularLabel());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 1;
        gridPanel.add(textIntroduction1, constraintsGrid);
    
        JLabel textIntroduction2 = new JLabel(text[2]);
        textIntroduction2.setFont(configStyle.regularLabel());
        textIntroduction2.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        gridPanel.add(textIntroduction2, constraintsGrid);

        constraintsMain.gridy = 0;
        mainPanel.add(gridPanel,constraintsMain);
        

		JPanel containerName = new JPanel(new FlowLayout());
		containerName.setBackground(new Color(0, 0, 0,0));

		JLabel nameLabel = new JLabel("Nome:");
		nameLabel.setFont(configStyle.regularLabel());
		JTextField nameTextField = new JTextField(20);
		nameTextField.setFont(configStyle.regularLabel());
		
		nameTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
                //AQUI FICA A STRING COM O NOME DO VENCEDOR
                String enteredName = nameTextField.getText();
				
                //AQUI FICA O TEMPO QUE ELE FEZ (ler dos arquivos e somar)
                
                Jogo.rankingScreen = new RankingScreen();
                goTo(Jogo.rankingScreen); 

				//setar o nome do jogador aqui, da classe
			}
		});

		containerName.add(nameLabel);
		containerName.add(nameTextField);

        constraintsMain.gridy = 1;
		mainPanel.add(containerName,constraintsMain);

        add(mainPanel);
    };
}



