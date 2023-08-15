package src.com.game.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class FaseIntroduction extends Screen {
    Fonts configStyle = new Fonts();
    private String[] text = new String[3]; 

    public FaseIntroduction(String id) {
        if(id == "1"){
            this.text[0] = "O INF é um lugar distante.";
            this.text[1] = "É preciso enfrentar uma grande jornada para descer até a matemática.";
            this.text[2] = "Desvie dos obstaculos para cumprir seu objetivo."; 
        }    
        else if(id == "2"){
            this.text[0] =  "Os prédios da matemática são todos iguais.";
            this.text[1] = "Se você for capaz de encontrar a sala do professor...";
            this.text[2] = "Poderá rever sua nota e voltar a sua forma normal!";
        }

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
                switch (id){
                    case "1": 
                        goTo(Jogo.gameScreen);
                        Jogo.initNewGame("1");
                        break;
                    case "2":
                        goTo(Jogo.gameScreen);
                        Jogo.initNewGame("2");
                        break;
                }
                //goTo(Jogo.mapaScreen);
            }
        });
    }    
}



