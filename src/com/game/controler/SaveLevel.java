package src.com.game.controler;

import java.io.*;
import src.com.game.model.Level;

public class SaveLevel {

//     public static void main(String[] args) {
//     Level level = new Level("1",2,3,Jogo.PATH_LEVEL1);
//     saveLevel(level, "1");
//     Level level2 = new Level("2",2,3,Jogo.PATH_LEVEL2);
//     saveLevel(level2, "2");

//     Level levelteste = loadLevel("2"); 
//     Level levelteste2 = loadLevel("1"); 

// }
    public static void saveLevel(Level level, String id) {
        String path = "src/com/game/controler/obj/" + id + ".dat"; 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(level);
            System.out.println("Informações de progresso salvas com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Level loadLevel(String id) {
        String path = "src/com/game/controler/obj/" + id + ".dat"; 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            // System.out.println("oii deu certooooo");
            return (Level) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
