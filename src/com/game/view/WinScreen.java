package src.com.game.view;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import src.com.game.controler.GameProgress;
import src.com.game.controler.Jogo;
import src.com.game.controler.LevelProgress;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class WinScreen extends Screen {
    Fonts configStyle = new Fonts();

    private String[] text = {
        "O aluno finalmente conseguiu chegar ao professor.",
        "Agora você permanecerá como humano!",
        "(Até a próxima cadeira da matemática)",
    };

    public void saveRanking(int points, String playerName) {
            try {
                FileWriter fileWriter = new FileWriter("src/com/game/view/ranking.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String pointsString = Integer.toString(points);
                bufferedWriter.write(playerName + ": " + pointsString + " segundos");
                bufferedWriter.newLine();;
                bufferedWriter.close();
    
                System.out.println("Variável salva com sucesso no arquivo do ranking");
            } catch (IOException e) {
                System.err.println("Erro ao salvar a variável no arquivo: " + e.getMessage());
            }
        }


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
                String enteredName = nameTextField.getText();
				GameProgress.printGameProgress();
                LevelProgress[] playerProgress = GameProgress.loadGameProgress();
                int seconds = 0, minutes = 0; 
                seconds = playerProgress[0].getTime() + playerProgress[1].getTime();
                minutes = (int) seconds/(60000/(Jogo.STANDART_INTERVAL));

                String timePrint = "";
                timePrint = String.valueOf(minutes) + "min" + String.valueOf(seconds) + "s";

                System.out.println(enteredName + ": " + timePrint);

                saveRanking(seconds, enteredName);
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



