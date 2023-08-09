package style;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;


public class Fonts{
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
