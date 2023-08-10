package src.com.game.model;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class TelaRankings {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ranking de Jogadores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new GridBagLayout());

		GridBagConstraints duvidei = new GridBagConstraints();

        JLabel textoLabel = new JLabel("RANKING");
        textoLabel.setFont(new Font("Arial", Font.BOLD, 40));
        textoLabel.setBounds(570, 70, 300, 80); // (x, y, largura, altura)

        duvidei.gridx = 0;
		duvidei.gridy = 0;
        frame.add(textoLabel, duvidei);

        // Adicionando o JLabel à janela

        List<Player> players = new ArrayList<>();
        players.add(new Player("Juliana", 150));
        players.add(new Player("Arthur", 200));
        players.add(new Player("Julia", 100));
        players.add(new Player("JP", 120));
        
        // Ordenar os jogadores por pontuação
        Collections.sort(players, Comparator.comparingInt(p -> +p.score));
        
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        for (Player player : players) {
            listModel.addElement(player.name + " - tempo: " + player.score + " segundos");
        }
        
        JList<String> playerList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(playerList);
        //scrollPane.setFont(new Font("Arial", Font.BOLD, 70));
        duvidei.gridx = 0;
		duvidei.gridy = 1;
        frame.getContentPane().add(scrollPane, duvidei);
        
        frame.setVisible(true);
    }
}
