package src.com.game.utils.style;

import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Images {
    private BufferedImage backgroundImage;
    
    public Images(){
        try {
            backgroundImage = ImageIO.read(new File("resources/sprites/error.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("deu mto ruim");
        }
    }

    public BufferedImage itemMapa(String name){
        switch(name){
            case "powerup":
                try {
                    backgroundImage = ImageIO.read(new File("resources/sprites/cafe.png"));        
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("deu ruim");
                }
                break; 
            case "energy": 
                try {
                    backgroundImage = ImageIO.read(new File("resources/sprites/energy.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("deu ruim");
                }
                break; 
        }
        return backgroundImage; 
    }
}
