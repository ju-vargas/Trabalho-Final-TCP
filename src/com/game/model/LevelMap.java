package src.com.game.model;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import src.com.game.controler.Jogo;


public class LevelMap {
    private int mapId; 
    private int[][] mapConstraints;
    private int[] randomPosition = new int[2];
    private Random random;

    public LevelMap(int id, String path){
        this.mapId = id;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int[][] matrix = new int[Jogo.XBlocks][Jogo.YBlocks];

            for (int rowIndex = 0; rowIndex < Jogo.XBlocks; rowIndex++) {
                String line = reader.readLine();
                String[] components = line.split(" ");

                for (int colIndex = 0; colIndex < Jogo.YBlocks; colIndex++) {
                matrix[rowIndex][colIndex] = Integer.parseInt(components[colIndex]);
                }
            }
            reader.close();
            this.mapConstraints = matrix;

        } catch (IOException e) {
            e.printStackTrace();
            this.mapConstraints = null;
        }
    }

    public int[][] getMapConstraints() {
        return this.mapConstraints;
    }

    public int[] getRandomCoordinates() {
        random = new Random();
        boolean validPosition = false;
        int randomX;
        int randomY;
        do{
            randomX = random.nextInt(Jogo.XBlocks-1);
            randomY = random.nextInt(Jogo.YBlocks-1);
            validPosition = this.mapConstraints[randomX][randomY] == 0 ? true : false;
        }while(!validPosition);

        this.randomPosition[0] = randomX*Jogo.BLOCK_SIZE;
        this.randomPosition[1] = Jogo.HEADER_SIZE+randomY*Jogo.BLOCK_SIZE;
    
        return this.randomPosition;
    }    
    public void render(Graphics g){
        for (int i = 0; i < this.mapConstraints.length; i++) {
            for (int j = 0; j < this.mapConstraints[i].length; j++) {
                int blockID = this.mapConstraints[i][j];
                switch (blockID){
                    case 0 :
                        g.setColor(new Color(((i*1) % 255), (i*2) % 255, (i*1) % 255));
                        break;
                    case 1:
                        g.setColor(new Color(255, 0, 0));
                        break;
                    }
                g.fillRect(i*Jogo.BLOCK_SIZE, Jogo.HEADER_SIZE+j*Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            }
        }
    }
}

