package src.com.game.controler;

import java.io.*;
import src.com.game.model.Level;

public class SaveLevel {
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
            return (Level) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
