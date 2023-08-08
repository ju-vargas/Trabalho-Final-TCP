package src.com.game.config;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;


public class Config{
    public static Font FONT;

    public Config(){
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT,
            new File("resources/Margarine-Regular.ttf"));
        }catch (FontFormatException | IOException e){
            FONT = new Font("Arial", Font.BOLD, 16);
        }    
    }

    //INTRODUCTION ----  
    public Font fontScreenIntro(){
        return FONT.deriveFont(Font.PLAIN, 24);
    }

    //RULES -----
    public Font fontScreenRules(){
        return FONT.deriveFont(Font.PLAIN, 16);
    }

    //WIN -----
    public Font fontScreenWin(){
        return FONT.deriveFont(Font.PLAIN, 24);
    }

    //BUTTON -----
    public Font fontButton(){
        return FONT.deriveFont(Font.PLAIN, 12);
    }
    

}
