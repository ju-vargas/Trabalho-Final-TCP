package src.com.game.view;

import java.awt.*;
import javax.swing.*;

import src.com.game.model.Tela;
import src.com.game.config.Config;

public class RulesScreen extends Tela {
    Config configStyle = new Config();

    private String[] rules = {
        "Não pode bilisca",
        "Não chutar. Mostrar língua",
        "Não pode morder",
		"Não pode dizer que vai matar os colegas",
		"Não pode ficar emburrada",
		"Não apilhidar, os colegas",
		"Não implicar com os colegas"
    };


    public RulesScreen() {
        setLayout(new GridBagLayout());
        setBackground(Color.PINK);     
    
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(0,0,0,0));
        GridBagConstraints constraintsMain = new GridBagConstraints();
        constraintsMain.insets = new Insets(10,10,10,10); 
		
		JLabel title = new JLabel("REGRAS"); 
		title.setFont(configStyle.fontTitles());
        title.setOpaque(true);
        title.setBackground(Color.YELLOW);
		constraintsMain.gridy = 0;
        mainPanel.add(title,constraintsMain);
		
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraintsGrid = new GridBagConstraints();
        gridPanel.setBackground(Color.YELLOW);

        JLabel rule0 = new JLabel(rules[0]);
        rule0.setFont(configStyle.fontScreenRules());
        rule0.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 0;
        gridPanel.add(rule0, constraintsGrid);

 		JLabel rule1 = new JLabel(rules[1]);
        rule1.setFont(configStyle.fontScreenRules());
        rule1.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 1;
        gridPanel.add(rule1, constraintsGrid);

		JLabel rule2 = new JLabel(rules[2]);
        rule2.setFont(configStyle.fontScreenRules());
        rule2.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 2;
        gridPanel.add(rule2, constraintsGrid);

		JLabel rule3 = new JLabel(rules[3]);
        rule3.setFont(configStyle.fontScreenRules());
        rule3.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 3;
        gridPanel.add(rule3, constraintsGrid);

		JLabel rule4 = new JLabel(rules[4]);
        rule4.setFont(configStyle.fontScreenRules());
        rule4.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 4;
        gridPanel.add(rule4, constraintsGrid);

		JLabel rule5 = new JLabel(rules[5]);
        rule5.setFont(configStyle.fontScreenRules());
        rule5.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 5;
        gridPanel.add(rule5, constraintsGrid);

		JLabel rule6 = new JLabel(rules[6]);
        rule6.setFont(configStyle.fontScreenRules());
        rule6.setHorizontalAlignment(SwingConstants.CENTER);
        constraintsGrid.gridy = 6;
        gridPanel.add(rule6, constraintsGrid);

		constraintsMain.gridy = 1;
		mainPanel.add(gridPanel, constraintsMain);
        add(mainPanel);
    };
}



