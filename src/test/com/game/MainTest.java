package src.test.com.game;

import src.test.com.game.controler.SaveLevelTest;
import src.test.com.game.model.ScreenTest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class MainTest {
    public static void main(String [] args){
        SaveLevelTest saveTest = new SaveLevelTest();
        ScreenTest telaTest = new ScreenTest();

        //saveTest.testSaveLevelFileExists();
        //telaTest.testTelaCreation();
    }
}
