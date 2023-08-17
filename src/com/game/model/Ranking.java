package src.com.game.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    public void ranking(){
        String filename = "src/com/game/controler/ranking.txt"; 

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
                
    }

    public void saveRanking(int points, String playerName) {
        try {
            FileWriter fileWriter = new FileWriter("src/com/game/controler/ranking.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String pointsString = Integer.toString(points);
            bufferedWriter.write(playerName + ": " + pointsString + " segundos");
            bufferedWriter.newLine();;
            bufferedWriter.close();

            System.out.println("Variável salva com sucesso no arquivo do ranking");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a variável no arquivo: " + e.getMessage());
        }
    }
    
}
