package src.com.game.model;
import java.awt.*;

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
        int position[] = LevelMap.getPositionByCoordinates(coordinates);
        g.drawImage(Images.itemMapa(imageName), position[0], position[1], Jogo.BLOCK_SIZE, Jogo.BLOCK_SIZE,null);
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
