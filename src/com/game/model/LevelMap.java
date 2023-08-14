package src.com.game.model;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.Serializable;


import src.com.game.controler.Jogo;


public class LevelMap implements Serializable{
    //private String mapId; 
    private int[][] mapConstraints;
    private int[] pointCoordinates = new int[2];
    private int[] powerUpCoordinates = new int[2];
    private Random random;

    public int[] getPointCoordinates() {
        return pointCoordinates;
    }

    public void setPointCoordinates(int[] pointCoord) {
        this.pointCoordinates = pointCoord;
        this.mapConstraints[pointCoord[0]][pointCoord[1]] = Jogo.POINT_ID;
    }

    public int[] getPowerUpCoordinates() {
        return powerUpCoordinates;
    }

    public void setPowerUpCoordinates(int[] powerUpCoord) {
        this.powerUpCoordinates = powerUpCoord;
        this.mapConstraints[powerUpCoord[0]][powerUpCoord[1]] = Jogo.POWERUP_ID;
    }
    
    public LevelMap(String id, String path){
        //this.mapId = id;
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

    public static void printMap(int[][] map){
        for (int[] row : map) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public int[] getRandomCoordinates() {
        int[] randomCoordinates = new int[2];

        random = new Random();
        boolean validPosition = false;
        int randomX;
        int randomY;
        do{
            randomX = random.nextInt(Jogo.XBlocks-1);
            randomY = random.nextInt(Jogo.YBlocks-1);
            validPosition = this.mapConstraints[randomX][randomY] == 0 ? true : false;
        }while(!validPosition);

        randomCoordinates[0] = randomX;
        randomCoordinates[1] = randomY;
    
        return randomCoordinates;
    }    

    public static int[] getPositionByCoordinates(int[] coord){
        int position[] = {coord[0] * Jogo.BLOCK_SIZE, coord[1]*Jogo.BLOCK_SIZE + Jogo.HEADER_SIZE};
        return position;
    }

    public void removeObject(int[] coord, PowerUp pw){
        this.mapConstraints[coord[0]][coord[1]] = 0;
        pw.setCoordinates(null);
    }

    public void removeObject(int[] coord){
        this.mapConstraints[coord[0]][coord[1]] = 0;
    }

    public void render(Graphics g){
        for (int i = 0; i < this.mapConstraints.length; i++) {
            for (int j = 0; j < this.mapConstraints[i].length; j++) {
                int blockID = this.mapConstraints[i][j];
                switch (blockID){
                    case Jogo.EMPTY_BLOCK_ID:
                        g.setColor(new Color(((i*1) % 255), (i*2) % 255, (i*1) % 255));
                        break;
                    case Jogo.OBSTACLE_ID:
                        g.setColor(new Color(255, 0, 0));
                        break;
                    }
                g.fillRect(i*Jogo.BLOCK_SIZE, j*Jogo.BLOCK_SIZE + Jogo.HEADER_SIZE, Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            }
        }
    }
}

