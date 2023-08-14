package src.com.game.model;
import java.io.Serializable;

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
