package src.com.game.model;
import java.awt.*;

import javax.swing.ImageIcon;

import src.com.game.controler.Jogo;
import src.com.game.utils.style.Images;

public abstract class LevelMapObject {
    private int[] coordinates = new int[2]; 
    private String imageName = "";

    public LevelMapObject(int[] coord, String imageName){
        this.coordinates = coord;
        this.imageName = imageName;
    }

    public void render(Graphics g){
        ImageIcon icon = Images.itemMapa(imageName);
        int position[] = LevelMap.getPositionByCoordinates(coordinates);
        int x = position[0];
        int y = position[1];
        icon.paintIcon(null, g, x, y);
        //g.drawImage(images.itemMapa("point"), this.position[0],this.position[1],Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE,null);
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
