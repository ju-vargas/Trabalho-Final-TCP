package src.com.game.view;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.game.controler.Game;
import src.com.game.model.Ranking;
import src.com.game.model.Screen;
import src.com.game.utils.style.Fonts;

public class RankingScreen extends Screen {
    public RankingScreen() {
        super();

        Fonts font = new Fonts();

        setLayout(new GridBagLayout());

        GridBagConstraints duvidei = new GridBagConstraints();
        duvidei.insets = new Insets(10, 10, 10, 10);

        JLabel textoLabel = new JLabel("RANKING");
        textoLabel.setFont(font.boldTitle());
        textoLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)

        duvidei.gridx = 0;
        duvidei.gridy = 0;
        add(textoLabel, duvidei);

        Ranking run = new Ranking();
        run.ranking();

        String filename = "src/com/game/controler/ranking.txt";

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
