package src.com.game.view;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Jogo;
import src.com.game.model.Tela;
import src.com.game.utils.TelaUtils;

public class GameScreen extends Tela {
    GameView gameView = new GameView();

    public GameScreen() {
        super();
        add(gameView);
        setTitle("Jogo da Cobrinha - Snake game");
        // setLayout(new GridBagLayout()); // 1 linha e 2 colunas

        // // Criação dos painéis
        // JPanel yellowPanel = new JPanel();
        // yellowPanel.setBackground(Color.YELLOW);

        // JPanel redPanel = new JPanel();
        // redPanel.setBackground(new Color(255,255,255,255));

        // GridBagConstraints constraints = new GridBagConstraints();
        // constraints.fill = GridBagConstraints.BOTH;

        // // Configuração de pesos para os painéis
        // constraints.weightx = 0.99; // Painel amarelo ocupa 90%
        // constraints.weighty = 1;
        // add(gameView, constraints);

        
        // JButton button = new JButton("Clique aqui");
        
        // // Adicionar um ouvinte de ação ao botão
        // button.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         goTo(Jogo.rankingScreen);
        //     }
        // });
        // redPanel.add(button);
        // constraints.weightx = 0.01; // Painel vermelho ocupa 10%
        // constraints.weighty = 0.9;
        // add(redPanel, constraints);
    }

    public void initNewGame(String id){
        gameView.startGameLevel(id);
    }

    public void changeScreen(){
        goTo(Jogo.rankingScreen);
    }
}
