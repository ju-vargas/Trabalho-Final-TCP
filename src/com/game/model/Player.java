package src.com.game.model;

import java.awt.*;
import java.io.Serializable;

import src.com.game.controler.Jogo;

public class Player implements Serializable{
    private String name;
    private char direction;
    private int size; 
    private int time; 
    private int speed; 
    private int points;
    private boolean isDead; 

    private int[] bodyX = new int[Jogo.UNITS];;
    private int[] bodyY = new int[Jogo.UNITS];;
    
    public Player(char direction){
        this.name = "";
        this.direction = direction;
        this.size = Jogo.INICIAL_PLAYER_SIZE; 
        this.time = 0; 
        this.speed = 0;
        this.points = 0;
        this.isDead = false; 
    }
    /*GETTERS and SETTERS */
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
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
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getPoints(){
        return this.points;
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

    public boolean checkCollision(int[][] map){
        for (int i = this.size; i > 0; i--) {
            if (this.bodyX[0] == this.bodyX[i] && this.bodyY[0] == this.bodyY[i]) {
                this.isDead = true;
                break;
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1){
                    int[] position = getPosition(i,j);
                    if (position[0] == this.bodyX[0] && position[1] == this.bodyY[0]){
                            this.isDead = true;
                    }
                }
            }
        }
        if (this.bodyX[0] < 0 || this.bodyX[0] > Jogo.MAX_WIDTH) {
            isDead = true;
        }
        if (this.bodyY[0] < 0 || this.bodyY[0] > Jogo.MAX_HEIGHT) {
            isDead = true;
        }
        return this.isDead;
    }
    private int[] getPosition(int i, int j){
        int[] position = new int[2];
        position[0] = i*Jogo.BLOCK_SIZE;
        position[1] = Jogo.HEADER_SIZE+j*Jogo.BLOCK_SIZE;
        return position;
    }

    public boolean madePoint(int[] pos){
        if (this.bodyX[0] == pos[0] && this.bodyY[0] == pos[1]) {
            this.increaseSize();
            this.points++;
            return true; 
        }
        return false;
    }

    public void render(Graphics g){
        for (int i = 0; i < this.size; i++) {
            if (i == 0) {
                g.setColor(new Color(223, 113, 37));
                g.fillRect(this.bodyX[0], this.bodyY[0], Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            } else {
                g.setColor(new Color(214, 154, 58));
                g.fillRect(this.bodyX[i], this.bodyY[i], Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE);
            }
        }
    }
}


