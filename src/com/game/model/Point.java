package src.com.game.model;
import java.awt.*;
import java.io.Serializable;

import javax.swing.ImageIcon;

import src.com.game.controler.Jogo;
import src.com.game.utils.style.Images;

public class Point implements Serializable{
    private int[] position = new int[2]; 
    private Images images = new Images();
    
    public Point(int[] pos){
        this.position = pos;
    }

    public void render(Graphics g){
        ImageIcon icon = images.itemMapa("point");
        int x = this.position[0];
        int y = this.position[1];
        icon.paintIcon(null, g, x, y);
        //g.drawImage(images.itemMapa("point"), this.position[0],this.position[1],Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE,null);
    }

    public void setPosition(int[] pos){
        this.position = pos;
    }

    public int[] getPosition(){
        return this.position;
    }
}
