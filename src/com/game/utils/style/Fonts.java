package src.com.game.utils.style;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.FontFormatException;


public class Fonts implements Serializable{
    public Font FONT;

    public Fonts(){
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT,
            new File("resources/font/Margarine-Regular.ttf"));
            System.out.println("sucesso");

        }catch (FontFormatException | IOException e){
            System.out.println(e);
            System.out.println("nao achei");
            FONT = new Font("Arial", Font.BOLD, 16);
        }    
    }



    //LABELS -----
    public Font smallLabel(){
        return FONT.deriveFont(Font.PLAIN, 12);
    }
    public Font regularLabel(){
        return FONT.deriveFont(Font.PLAIN, 16);
    }
    public Font boldLabel(){
        return FONT.deriveFont(Font.PLAIN, 24);
    }

    //BUTTONS -----
    public Font smallButton(){
        return FONT.deriveFont(Font.PLAIN, 12);
    }

    public Font regularButton(){
        return FONT.deriveFont(Font.PLAIN, 16);
    }

    public Font boldButton(){
        return FONT.deriveFont(Font.PLAIN, 22);
    }

    //TITLES -----
    public Font smallTitle(){
        return FONT.deriveFont(Font.PLAIN, 24);
    }
    public Font regularTitle(){
        return FONT.deriveFont(Font.PLAIN, 30);
    }    
    public Font boldTitle(){
        return FONT.deriveFont(Font.PLAIN, 55);
    }    
}
