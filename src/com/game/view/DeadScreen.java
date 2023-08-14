package src.com.game.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Tela;
import src.com.game.utils.style.Fonts;

public class DeadScreen extends Tela {
    Fonts configStyle = new Fonts();

    public DeadScreen() {
      
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

        // JLabel textIntroduction = new JLabel(text[0]);
        // textIntroduction.setFont(configStyle.regularLabel());
        // textIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
        // constraintsGrid.gridy = 1;
        // constraintsGrid.gridx = 2;
        // gridPanel.add(textIntroduction, constraintsGrid);
    
        JLabel textIntroduction1 = new JLabel("Você morreu!");
        textIntroduction1.setFont(configStyle.regularLabel());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        constraintsMain.gridx = 2; 
        gridPanel.add(textIntroduction1, constraintsGrid);
    
        // JLabel textIntroduction2 = new JLabel(text[2]);
        // textIntroduction2.setFont(configStyle.regularLabel());
        // textIntroduction2.setHorizontalAlignment(SwingConstants.CENTER);
        // constraintsGrid.gridy = 3;
        // gridPanel.add(textIntroduction2, constraintsGrid);

        constraintsMain.gridy = 0;
        mainPanel.add(gridPanel,constraintsMain);
        
        JButton mapButton = new JButton("Mapa");
        mapButton.setFont(configStyle.regularButton());
        constraintsMain.gridy = 1;
        constraintsMain.gridx = 1; 
        mainPanel.add(mapButton,constraintsMain);
        add(mainPanel);

        JButton menuButton = new JButton("Menu");
        menuButton.setFont(configStyle.regularButton());
        constraintsMain.gridx = 3;
        mainPanel.add(menuButton,constraintsMain);
        add(mainPanel);

        mapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.mapaScreen);
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.optionsScreen);
            }
        });
    }    
}



