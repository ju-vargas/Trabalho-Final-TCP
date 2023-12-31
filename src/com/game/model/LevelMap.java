package src.com.game.model;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.Serializable;


import src.com.game.controler.Game;

 
public class LevelMap implements Serializable{
    private int[][] mapConstraints;
    private int[] pointCoordinates = new int[2];
    private int[] powerUpCoordinates = new int[2];
    private Random random;

    public void setMapConstraints(int[][] mapConstraints) {
        this.mapConstraints = mapConstraints;
    }

    public int[] getPointCoordinates() {
        return pointCoordinates;
    }

    public void setPointCoordinates(int[] pointCoord) {
        this.pointCoordinates = pointCoord;
        this.mapConstraints[pointCoord[0]][pointCoord[1]] = Game.POINT_ID;
    }

    public int[] getPowerUpCoordinates() {
        return powerUpCoordinates;
    }

    public void setPowerUpCoordinates(int[] powerUpCoord) {
        this.powerUpCoordinates = powerUpCoord;
        this.mapConstraints[powerUpCoord[0]][powerUpCoord[1]] = Game.POWERUP_ID;
    }
     
    public LevelMap(String id, String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int[][] matrix = new int[Game.X_BLOCKS][Game.Y_BLOCKS];

            for (int colIndex = 0; colIndex < Game.Y_BLOCKS; colIndex++) {
                String line = reader.readLine();
                String[] components = line.split(" ");
                for (int rowIndex = 0; rowIndex < Game.X_BLOCKS; rowIndex++) {
                    matrix[rowIndex][colIndex] = Integer.parseInt(components[rowIndex]);
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
            randomX = random.nextInt(Game.X_BLOCKS-1);
            randomY = random.nextInt(Game.Y_BLOCKS-1);
            validPosition = this.mapConstraints[randomX][randomY] == 0 ? true : false;
        }while(!validPosition);

        randomCoordinates[0] = randomX;
        randomCoordinates[1] = randomY;
    
        return randomCoordinates;
    }    

    public static int[] getPositionByCoordinates(int[] coord){
        int position[] = {coord[0] * Game.BLOCK_SIZE, coord[1]*Game.BLOCK_SIZE + Game.HEADER_SIZE};
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
                    case Game.EMPTY_BLOCK_ID:
                        g.setColor(new Color(0,0,0,0));
                        g.fillRect(i*Game.BLOCK_SIZE, j*Game.BLOCK_SIZE + Game.HEADER_SIZE, Game.BLOCK_SIZE, Game.BLOCK_SIZE);
                        break;
                    case Game.OBSTACLE_ID:
                        int coord[] = {i,j};
                        Obstacle obstacle = new Obstacle(coord, "obstacle");
                        obstacle.render(g);
                        break;
                }
            }
        }
    }
}

