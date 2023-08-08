package src.com.game.view;

import java.awt.*;
import javax.swing.*;

import src.com.game.model.Tela;
import src.com.game.config.Config;

public class IntroductionScreen extends Tela {
    Config configStyle = new Config();
    public int sizeY = getHeight();
    public int sizeX = getWidth();

    private String[] text = {
        "O semestre foi difícil... pela terceira vez.",
        "Mas espere! O professor esqueceu de considerar uma questão da prova",
        "Encontre o professor para reaver sua nota e quebrar a maldição.",
    };


    public IntroductionScreen() {
        setBackground(Color.PINK);     

        setLayout(new GridBagLayout());
        GridBagConstraints duvidei = new GridBagConstraints();
        duvidei.insets = new Insets(10, 10, 10, 10); // Espaçamento de 10 pixels em todas as direções
        

        // Configuração do retângulo
        duvidei.gridx = 0;
        duvidei.gridy = 0;
        duvidei.weightx = 1.0;
        duvidei.weighty = 1.0;
        duvidei.anchor = GridBagConstraints.CENTER;

        JPanel rectanglePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = 1200;
                int height = 1200;
                int x = (400 - width) / 2;
                int y = (400 - height) / 2;
                g.setColor(Color.BLUE);
                g.fillRect(x, y, width, height);
            }
        };
        add(rectanglePanel, duvidei);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints teste = new GridBagConstraints();

        JLabel textIntroduction = new JLabel(text[0]);
        textIntroduction.setFont(configStyle.fontScreenIntro());
        textIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
        teste.gridy = 1;
        teste.gridx = 2;

        teste.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        gridPanel.add(textIntroduction, teste);
    
        JLabel textIntroduction1 = new JLabel(text[1]);
        textIntroduction1.setFont(configStyle.fontScreenIntro());
        textIntroduction1.setHorizontalAlignment(SwingConstants.CENTER);
        teste.gridy = 2;
        gridPanel.add(textIntroduction1, teste);
    
        JLabel textIntroduction2 = new JLabel(text[2]);
        textIntroduction2.setFont(configStyle.fontScreenIntro());
        textIntroduction2.setHorizontalAlignment(SwingConstants.CENTER);
        teste.gridy = 3;
        gridPanel.add(textIntroduction2, teste);

        JButton continueToNext = new JButton("Continuar");
        continueToNext.setFont(configStyle.fontButton());
        duvidei.gridy = 4; 
        duvidei.gridx = 2;

        duvidei.anchor = GridBagConstraints.CENTER;        
        gridPanel.add(continueToNext, duvidei); // Adiciona o botão abaixo do quadrado     

        duvidei.gridy = 0; 
        duvidei.gridx = 0; 

        add(gridPanel,duvidei);
    }   

    
    // @Override
    // protected void paintComponent(Graphics g) {
    //     // Preencha o JPanel com 50% de opacidade (valor entre 0.0f e 1.0f)
    //     Graphics2D g2d = (Graphics2D) g;
    //     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
    //     // Preencha o JPanel com a cor desejada
    //     g2d.setColor(Color.BLACK);
    //     g2d.fillRect(0, 0, getWidth(), getHeight());
    // }


}
