package src.com.game.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import src.com.game.controler.Jogo;
import src.com.game.model.Tela;


class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


public class RankingScreen extends Tela {
        //public static void main(String[] args) {

        //JFrame frame = new JFrame("Ranking de Jogadores");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1280, 720);
        
        public RankingScreen() {
            super();

            setLayout(new GridBagLayout());

            GridBagConstraints duvidei = new GridBagConstraints();
            duvidei.insets = new Insets(10,10,10,10);
    
            JLabel textoLabel = new JLabel("RANKING");
            textoLabel.setFont(new Font("Arial", Font.BOLD, 40));
            textoLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)
            
            duvidei.gridx = 0;
            duvidei.gridy = 0;
            add(textoLabel, duvidei);

            String filename = "src/com/game/view/ranking.txt"; // Substitua pelo caminho do seu arquivo

            int lineCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                while (reader.readLine() != null) {
                    lineCount++;
                }

                System.out.println("O arquivo tem " + lineCount + " linhas.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(lineCount == 6){
                StringBuilder fileContent = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line).append("<br>"); // Adiciona a linha ao conteúdo com tag <br>
                    }
                
                    String content = "<html>" + fileContent.toString() + "</html>"; // Encapsula em <html>...</html>
                    
                    JLabel textooLabel = new JLabel(content);
                    textooLabel.setFont(new Font("Arial", Font.BOLD, 20));
                    textooLabel.setHorizontalAlignment(SwingConstants.LEFT); // Habilita HTML rendering
                    textooLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)
                    duvidei.gridy = 1;
                    duvidei.gridx = 0;
                    add(textooLabel, duvidei);
                    System.out.println("Conteúdo completo do arquivo:\n" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                JLabel textooooLabel = new JLabel("AAAAAAAAAA");
                textooooLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textooooLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)
                
            duvidei.gridx = 0;
            duvidei.gridy = 1;
            add(textoLabel, duvidei);
            }
            
            JButton menuButton = new JButton("Menu");
        
            duvidei.gridy = 2;
            duvidei.gridx = 0;
            add(menuButton, duvidei);
                
            menuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    goTo(Jogo.optionsScreen);
                };
            });
        }

}


