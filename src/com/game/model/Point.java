package src.com.game.model;
import java.awt.*;

import src.com.game.controler.Jogo;
import src.com.game.utils.style.Images;

public class Point {
    private int[] position = new int[2]; 
    private Images images = new Images();
    
    public Point(int[] pos){
        this.position = pos;
    }

    public void render(Graphics g){
        g.drawImage(images.itemMapa("point"), this.position[0],this.position[1],Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE,null);
    }

    public void setPosition(int[] pos){
        this.position = pos;
    }

    public int[] getPosition(){
        return this.position;
    }
}
