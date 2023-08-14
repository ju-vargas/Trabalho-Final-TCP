package src.test.com.game.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

import src.com.game.controler.SaveLevel;
import src.com.game.model.Level;

    public class SaveTest {
    
        @Test
        public void testSaveLevelFileExists() {

            int maxLevel = 3;

            System.out.println("Arquivos de save existentes:");
            for (int i = 1; i <= maxLevel; i++) {
                String id = String.valueOf(i);
                String path = "src/com/game/controler/obj/" + id + ".dat";
                File savedFile = new File(path);
        
                assertTrue("Level " + id + " exists", savedFile.exists());

                System.out.println(savedFile.getAbsolutePath());
            }
        }

    public static void main(String [] args){
        SaveTest saveTest = new SaveTest();

        saveTest.testSaveLevelFileExists();
        //saveTest.testLoadLevel();
    }


}


