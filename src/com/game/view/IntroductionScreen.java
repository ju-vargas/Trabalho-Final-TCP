package src.com.game.view;

import java.awt.*;
import javax.swing.*;

import src.com.game.model.Tela;
import src.com.game.config.Config;

public class IntroductionScreen extends Tela {
    Config configStyle = new Config();

    private String[] text = {
        "O semestre foi difícil... pela terceira vez.",
        "Mas espere! O professor esqueceu de considerar uma questão da prova",
        "Encontre o professor para reaver sua nota e quebrar a maldição.",
    };


    public IntroductionScreen() {
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
        textIntroduction.setFont(configStyle.fontScreenIntro());
        textIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 1;
        constraintsGrid.gridx = 2;
        gridPanel.add(textIntroduction, constraintsGrid);
    
        JLabel textIntroduction1 = new JLabel(text[1]);
        textIntroduction1.setFont(configStyle.fontScreenIntro());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        gridPanel.add(textIntroduction1, constraintsGrid);
    
        JLabel textIntroduction2 = new JLabel(text[2]);
        textIntroduction2.setFont(configStyle.fontScreenIntro());
        textIntroduction2.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 3;
        gridPanel.add(textIntroduction2, constraintsGrid);

        constraintsMain.gridy = 0;
        mainPanel.add(gridPanel,constraintsMain);
        
        JButton continueToNext = new JButton("Continuar");
        continueToNext.setFont(configStyle.fontButton());
        constraintsMain.gridy = 1;
        mainPanel.add(continueToNext,constraintsMain);
        add(mainPanel);
    };
}



