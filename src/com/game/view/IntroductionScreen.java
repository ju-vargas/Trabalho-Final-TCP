package src.com.game.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Game;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class IntroductionScreen extends Screen {
    Fonts configStyle = new Fonts();

    private String[] text = {
        "\"O semestre foi difícil... pela terceira vez.\"",
        "\"Mas espere! O professor esqueceu de considerar uma questão da prova\"",
        "\"Encontre o professor para reaver sua nota e quebrar a maldição.\"",
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
        gridPanel.setBackground(new Color(150,150,150,127));

        JLabel textIntroduction = new JLabel(text[0]);
        textIntroduction.setFont(configStyle.regularLabel());
        textIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 1;
        constraintsGrid.gridx = 2;
        gridPanel.add(textIntroduction, constraintsGrid);
    
        JLabel textIntroduction1 = new JLabel(text[1]);
        textIntroduction1.setFont(configStyle.regularLabel());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        gridPanel.add(textIntroduction1, constraintsGrid);
    
        JLabel textIntroduction2 = new JLabel(text[2]);
        textIntroduction2.setFont(configStyle.regularLabel());
        textIntroduction2.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 3;
        gridPanel.add(textIntroduction2, constraintsGrid);

        gridPanel.setBorder(new EmptyBorder(150, 30, 150, 30));
        constraintsMain.gridy = 0;
        mainPanel.add(gridPanel,constraintsMain);
        
        JButton continueToNext = new JButton("Continuar");
        continueToNext.setFont(configStyle.regularButton());
        constraintsMain.gridy = 1;
        mainPanel.add(continueToNext,constraintsMain);
        add(mainPanel);

        continueToNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                goTo(Game.mapaScreen);
            }
        });
    }    
}



