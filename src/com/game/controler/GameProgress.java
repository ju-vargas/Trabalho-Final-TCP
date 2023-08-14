package src.com.game.controler;

import java.io.*;
import src.com.game.controler.LevelProgress;

public class GameProgress {
    // public static void main(String[] args) {
    //      LevelProgress level1 = new LevelProgress(1, false, false, 0);
    //      LevelProgress level2 = new LevelProgress(2, false, false, 0);
    // //     // Salvar informações de progresso em um arquivo
    //      saveGameProgress(level1, level2);
    // //     // Carregar informações de progresso de um arquivo src\com\game\controler\obj\game_progress.dat
    //      LevelProgress[] loadedProgress = loadGameProgress();
    //      if (loadedProgress != null) {
    //          for (int i = 0; i < loadedProgress.length; i++) {
    //              System.out.println("Fase " + (i + 1) + ": Concluída=" + loadedProgress[i].isCompleted() + ", Tempo=" + loadedProgress[i].getTime());
    //          }
    //      }
    // }
    public static void clearGameProgress(int id){
        LevelProgress[] loadedProgress = loadGameProgress();
        switch (id){
            case 1: 
                LevelProgress level1 = new LevelProgress(1, false, false, 0);
                saveGameProgress(level1, loadedProgress[1]);
                // System.out.println("LIMPEI O 1");
                break;
                
            case 2: 
                LevelProgress level2 = new LevelProgress(2, false, false, 0);
                saveGameProgress(loadedProgress[0],level2);
                // System.out.println("LIMPEI O 2");
                break;
            
            default:
                break;
        }
    }

    public static void printGameProgress(){
        LevelProgress[] loadedProgress = loadGameProgress();
        if (loadedProgress != null) {
            for (int i = 0; i < loadedProgress.length; i++) {
                System.out.println("Fase " + (i + 1) + ": Concluída=" + loadedProgress[i].isCompleted() + ", Tempo=" + loadedProgress[i].getTime() + ", Andamento=" + loadedProgress[i].isRunning());
            }
        }    
    }

    public static void saveGameProgress(LevelProgress... progress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/game/controler/obj/game_progress.dat"))) {
            oos.writeObject(progress);
            System.out.println("Informações de progresso salvas com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LevelProgress[] loadGameProgress() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/game/controler/obj/game_progress.dat"))) {
            return (LevelProgress[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
