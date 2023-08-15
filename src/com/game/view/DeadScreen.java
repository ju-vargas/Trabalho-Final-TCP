package src.com.game.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Game;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class DeadScreen extends Screen {
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
        gridPanel.setBackground(new Color(150,150,150,127));
        gridPanel.setBorder(new EmptyBorder(60, 80, 60, 80));
    
        JLabel textIntroduction1 = new JLabel("Você morreu!");
        textIntroduction1.setFont(configStyle.regularLabel());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        constraintsMain.gridx = 2; 
        gridPanel.add(textIntroduction1, constraintsGrid);

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
                Game.gameScreen.changeScreenLevel();
                goTo(Game.mapaScreen);
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Game.optionsScreen);
            }
        });
    }    
}



