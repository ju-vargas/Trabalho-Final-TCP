package src.com.game.model;
import java.awt.*;
import java.io.Serializable;


import javax.swing.ImageIcon;
import src.com.game.model.LevelMapObject;
import src.com.game.utils.style.Images;;

public class Point extends LevelMapObject implements Serializable {  
    private static int value = 0;
    //private int[] position = new int[2]; 
    
    public Point(int[] coord, int value, String imageName){
        super(coord, imageName);
        Point.value = value;
    }

    public static void applyEffect(Player player){
        player.increasePoints(value);
        player.increaseSize();
    }
}
