package src.com.game.model;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import src.com.game.controler.Jogo;

public class Player implements Serializable{
    private String name;
    private char direction;
    private int size; 

    private LocalDateTime endSpeedUpTime; 

    private int speed; 
    private boolean isSpeededUp;

    private int points;
    private boolean isDead; 

    private int[] bodyX = new int[Jogo.UNITS];
    private int[] bodyY = new int[Jogo.UNITS];
    
    public Player(char direction){
        this.name = "";
        this.direction = direction;
        this.size = -1; 
        this.endSpeedUpTime = null; 
        this.speed = 1;
        this.points = 0;
        this.isDead = false; 
        bodyX[0] = 0;
        bodyY[0] = Jogo.HEADER_SIZE;
    }
    /*GETTERS and SETTERS */
    public LocalDateTime getEndSpeedUpTime() {
        return endSpeedUpTime;
    }
    public void setEndSpeedUpTime(LocalDateTime endSpeedUpTime) {
        this.endSpeedUpTime = endSpeedUpTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSpeed() {
        return speed;
    }
    public boolean isSpeededUp() {
        return isSpeededUp;
    }
    public void speedUp(int value){
        this.isSpeededUp = true;
        this.speed = value;
    }
    public void speedDown(){
        this.isSpeededUp = false;
        this.speed = 1;
    }
    public int getPoints(){
        return this.points;
    }
    public int getSize() {
        return size;
    }
    public void increaseSize() {
        this.size = size+1;
    }
    public void increasePoints(int point){
        this.points += point;
    }

    public void moveUp(){
        if (this.direction != 'B') {
            this.direction = 'C';
        }
    }
    public void moveDown(){
        if (this.direction != 'C') {
            this.direction = 'B';
        }
    }
    public void moveRight(){
        if (this.direction != 'E') {
            this.direction = 'D';
        }
    }
    public void moveLeft(){
        if (this.direction != 'D') {
            this.direction = 'E';
        }
    }

    public void walk(){
        for (int i = this.size; i > 0; i--) {
            this.bodyX[i] = this.bodyX[i - 1];
            this.bodyY[i] = this.bodyY[i - 1];
        }
        switch (this.direction) {
            case 'C':
                this.bodyY[0] = (this.bodyY[0] - Jogo.BLOCK_SIZE);
                break;
            case 'B':
                this.bodyY[0] = (this.bodyY[0] + Jogo.BLOCK_SIZE);
                break;
            case 'E':
                this.bodyX[0] = (this.bodyX[0] - Jogo.BLOCK_SIZE);
                break;
            case 'D':
                this.bodyX[0] = (this.bodyX[0] + Jogo.BLOCK_SIZE);
                break;
            default: 
                break;
        }
    }

    public boolean checkCollision(int[][] map, Level level){
        for (int i = this.size; i > 0; i--) {
            if (this.bodyX[0] == this.bodyX[i] && this.bodyY[0] == this.bodyY[i]) {
                this.isDead = true;
                // System.out.println("morreu por colidir no próprio corpo");
                break;
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] != 0){
                    int[] position = getPosition(i,j);
                    if (position[0] == this.bodyX[0] && position[1] == this.bodyY[0]){
                        if (map[i][j] == 1){
                            // System.out.println("morreu por colidir no mapa");
                            this.isDead = true;
                        }
                        if (map[i][j] == 2)
                            level.upScore();
                        if (map[i][j] == 3)
                            level.checkPowerUp();
                    }
                }
            }
        }
        // System.out.println(this.bodyX[0]+","+(this.bodyY[0]+Jogo.HEADER_SIZE));
        if (this.bodyX[0] < 0 || this.bodyX[0] + Jogo.BLOCK_SIZE > Jogo.WIDTH) {
            isDead = true;
            // System.out.println("morreu por colidir passar no width");
        }
        if (this.bodyY[0] < Jogo.HEADER_SIZE || this.bodyY[0] + Jogo.HEADER_SIZE > Jogo.HEIGHT) {
            // System.out.println("morreu por colidir passar no height");
            isDead = true;
        }
        return this.isDead;
    }

    private int[] getPosition(int i, int j){
        int[] position = new int[2];
        position[0] = i*Jogo.BLOCK_SIZE;
        position[1] = j*Jogo.BLOCK_SIZE + Jogo.HEADER_SIZE;
        return position;
    }

    public boolean hasCollide(int[] coord){
        int position[] = LevelMap.getPositionByCoordinates(coord);
        if (this.bodyX[0] == position[0] && this.bodyY[0] == position[1]) {
            return true; 
        }
        return false;
    }

    public void render(Graphics g){
        for (int i = 0; i < this.size; i++) {
            if (i == 0) {
                g.setColor(new Color(223, 113, 37));
                g.fillRect(this.bodyX[0], this.bodyY[0], Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            } 
            else {
                g.setColor(new Color(214, 154, 58));
                g.fillRect(this.bodyX[i], this.bodyY[i], Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            }
        }
    }
}


