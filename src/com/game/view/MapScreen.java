package src.com.game.view;
import src.com.game.model.Level;
import src.com.game.model.Screen;
//import src.com.game.model.Save;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.utils.TimerUtils;
import src.com.game.utils.style.*;
import src.com.game.controler.LevelProgress;
import src.com.game.controler.SaveLevel;
import src.com.game.controler.GameProgress;
import src.com.game.controler.Jogo;

public class MapScreen extends Screen {

	public MapScreen(){
        super();
        setLocationRelativeTo(null);
        update();
	}
    
    public void update(){
        this.getContentPane().removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 75, 0, 75);	
		
        LevelProgress[] loadedProgress = GameProgress.loadGameProgress();
        String[] sprite = new String[3];
        for(int i = 0; i<2; i++){
            if (loadedProgress[i].isCompleted() == true){
                sprite[i] = "completebutton";
            }
            else if(loadedProgress[i].isRunning() == true){
                sprite[i] = "almostbutton"; 
            }
            else
                sprite[i] = "notbutton";
        }
        if(loadedProgress[0].isCompleted() & loadedProgress[1].isCompleted())
            sprite[2] = "completebutton";
        else   
            sprite[2] = "notbutton";
    
        JButton buttonMenu = createCircularButton("Menu", "menubutton");
		JButton button1 = createCircularButton("Fase 1", sprite[0]);
		JButton button2 = createCircularButton("Fase 2", sprite[1]);
		JButton button3 = createCircularButton("Fim",sprite[2]);
	
		constraints.gridx = 0;
		constraints.gridy = 0;
        this.add(buttonMenu,constraints); 

		constraints.gridx = 1;
		constraints.gridy = 1;
        int level1Time[] = TimerUtils.getTimeComponents(loadedProgress[0].getTime());
        JLabel label = new JLabel(Integer.toString(level1Time[0]) + "min" +Integer.toString(level1Time[1]) + "s");
        label.setBorder(new EmptyBorder(0, 0, 150, 0));
        this.add(label,constraints);
		this.add(button1, constraints);

		constraints.gridx = 2;
		constraints.gridy = 0;
        int level2Time[] = TimerUtils.getTimeComponents(loadedProgress[1].getTime());
        JLabel label2 = new JLabel(Integer.toString(level2Time[0]) + "min" +Integer.toString(level2Time[1]) + "s");
        label2.setBorder(new EmptyBorder(150, 0, 0, 0));
        this.add(label2,constraints);
		this.add(button2, constraints);

        constraints.gridx = 3;
		constraints.gridy = 1;
        int finalTime[] = TimerUtils.sum(level1Time, level2Time);
        JLabel label3 = new JLabel(Integer.toString(finalTime[0]) + "min" +Integer.toString(finalTime[1]) + "s");
        label3.setBorder(new EmptyBorder(0, 0, 150, 0));
		this.add(label3,constraints);
        this.add(button3, constraints);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loadedProgress[0].isCompleted());
                
                //SE esta completo e clica, refaz o nivel
                if (loadedProgress[0].isCompleted()){
                    GameProgress.clearGameProgress(1);
                    Level level1 = new Level("1",2,3,Jogo.PATH_LEVEL1);
                    SaveLevel.saveLevel(level1,"1");
                }

                //SE esta em progresso ou eh a primeira vez fazendo, só vai pro jogo
                
                Jogo.faseIntroduction = new FaseIntroduction("1");
                goTo(Jogo.faseIntroduction);
            }
        });

        // Adicionar um ActionListener para tratar o clique no botão
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadedProgress[0].isCompleted()){
                    if (loadedProgress[1].isCompleted()){
                        GameProgress.clearGameProgress(1);
                        Level level2 = new Level("1",2,3,Jogo.PATH_LEVEL2);
                        SaveLevel.saveLevel(level2,"2");
                        //manda a classe limpa
                    }
                    Jogo.faseIntroduction = new FaseIntroduction("2");
                    goTo(Jogo.faseIntroduction);
                } 
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadedProgress[1].isCompleted()){
                    goTo(Jogo.rankingScreen);
                } 
            }
        });

        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goTo(Jogo.optionsScreen);    
            }
        });
    }

    private static JButton createCircularButton(String label, String type) {
        Images imageFont = new Images();
        Fonts font = new Fonts();

        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(100, 100));

        button.setIcon(imageFont.button(type));

        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setFont(font.boldButton());
        return button;
    }
}
