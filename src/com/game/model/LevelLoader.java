package src.com.game.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import src.com.game.controler.Game;

/**
 * Carrega o arquivo do mapa original
 * como um novo mapa "em branco". Para
 * carregar e salvar progresso de um mapa,
 * use SaveLevel.
 */
public class LevelLoader {

    Map< String, Level > loadedLevels;

    public LevelLoader(){
        this.loadedLevels = new TreeMap<>();
    }

    /* Tenta encontrar um nível já carregado, ou o carrega */
    public Level getLevel(String id){
        Level level = loadedLevels.get(id);
        try {
            if( level == null ){
                loadedLevels.put( id, loadFromFile( id ) );
                level = loadedLevels.get(id);
            }
        } catch( IOException ex ){
            System.out.println("Fase de ID " + id + " não encontrada!");
        }
        return level;
    }

    private static Level loadFromFile(String id) throws IOException {
        String path = idToPath(id);

        BufferedReader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);

        ArrayList<String> levelStory = new ArrayList<>();
        int[][] matrix = new int[Game.X_BLOCKS][Game.Y_BLOCKS];


        for (int i = 0; i < Game.STORY_LINES; ++i) {
            String line = reader.readLine();
            levelStory.add(line);
        }

        String backgroundImageFile = reader.readLine();

        String[] pointsAndPowersLine = reader.readLine().split(" ");
        int numPowerUps = Integer.parseInt(pointsAndPowersLine[0]);
        int numPoints = Integer.parseInt(pointsAndPowersLine[1]);

        for (int colIndex = 0; colIndex < Game.Y_BLOCKS; colIndex++) {
            String line = reader.readLine();
            String[] components = line.split(" ");
            for (int rowIndex = 0; rowIndex < Game.X_BLOCKS; rowIndex++) {
                matrix[rowIndex][colIndex] = Integer.parseInt(components[rowIndex]);
            }
        }
        reader.close();

        LevelMap levelMap = new LevelMap(matrix);
        Level level = new Level(id, numPowerUps, numPoints, levelMap, backgroundImageFile);
        level.setStory(levelStory);

        return level;
    }

    private static String idToPath(String id){
        return Game.PATH_LEVEL_FOLDER + id + Game.PATH_LEVEL_SUFFIX;
    }
}
