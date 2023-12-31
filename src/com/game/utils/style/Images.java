package src.com.game.utils.style;
import javax.swing.ImageIcon;
import java.io.Serializable;

public class Images implements Serializable{
    private static ImageIcon backgroundIcon;
    
    public Images(){
        backgroundIcon = new ImageIcon("resources/sprites/error.png");
    }
    public static ImageIcon itemMapa(String name){
        backgroundIcon = new ImageIcon("resources/sprites/"+name+".png");
        return backgroundIcon; 
    }
    
    public ImageIcon button(String name){
        String path; 
        path = "resources/sprites/" + name + ".png";
        backgroundIcon = new ImageIcon(path);
        return backgroundIcon; 
    }

    public static ImageIcon headPlayer(String name){
        String path;
        path = "resources/sprites/" + name + ".png";
        backgroundIcon = new ImageIcon(path);
        return backgroundIcon;     
    }
}
