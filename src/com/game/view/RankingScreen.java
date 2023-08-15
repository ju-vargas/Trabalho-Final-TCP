package src.com.game.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

import src.com.game.controler.Game;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;


class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class RankingScreen extends Screen {
        //public static void main(String[] args) {

        //JFrame frame = new JFrame("Ranking de Jogadores");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1280, 720);
        
        public RankingScreen() {
            super();

            Fonts font = new Fonts();

            setLayout(new GridBagLayout());

            GridBagConstraints duvidei = new GridBagConstraints();
            duvidei.insets = new Insets(10,10,10,10);
    
            JLabel textoLabel = new JLabel("RANKING");
            textoLabel.setFont(font.boldTitle());
            textoLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)
            
            duvidei.gridx = 0;
            duvidei.gridy = 0;
            add(textoLabel, duvidei);

            String filename = "src/com/game/view/ranking.txt"; 

                List<String> lines = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
        
                    Collections.sort(lines, new Comparator<String>() {
                        @Override
                        public int compare(String line1, String line2) {
                            int seconds1 = Integer.parseInt(line1.split(": ")[1].split(" segundos")[0]);
                            int seconds2 = Integer.parseInt(line2.split(": ")[1].split(" segundos")[0]);
                            return Integer.compare(seconds1, seconds2);
                        }
                    });
        
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        for (String sortedLine : lines) {
                            writer.write(sortedLine);
                            writer.newLine();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                int lineCount = 0;

                StringBuilder fileContent = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null && lineCount < 5) {
                        fileContent.append(line).append("<br>"); 
                        lineCount++;
                    }
                
                    String content = "<html>" + fileContent.toString() + "</html>"; // Encapsula em <html>...</html>
                    
                    JLabel textooLabel = new JLabel(content);
                   // textooLabel.setFont(font.regularLabel());
                    textooLabel.setHorizontalAlignment(SwingConstants.LEFT); // Habilita HTML rendering
                    textooLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)
                    duvidei.gridy = 1;
                    duvidei.gridx = 0;
                    add(textooLabel, duvidei);
                    System.out.println("Conteúdo completo do arquivo:\n" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
            JButton menuButton = new JButton("Menu");
        
            duvidei.gridy = 2;
            duvidei.gridx = 0;
            add(menuButton, duvidei);
                
            menuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    goTo(Game.optionsScreen);
                };
            });
        }

}


