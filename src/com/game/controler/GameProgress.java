package src.com.game.controler;

import java.io.*;
import src.com.game.controler.LevelProgress;

public class GameProgress {

    public static void clearGameProgress(int id){
        LevelProgress[] loadedProgress = loadGameProgress();
        loadedProgress[id-1] = new LevelProgress(1, false, false, 0);
        saveGameProgress(loadedProgress);
    }

    public static void printGameProgress(){
        LevelProgress[] loadedProgress = loadGameProgress();
        if (loadedProgress != null) {
            for (int i = 0; i < loadedProgress.length; i++) {
                System.out.println("Fase " + (i + 1) + ": Concluída=" + loadedProgress[i].isCompleted() + ", Tempo=" + loadedProgress[i].getTime() + ", Andamento=" + loadedProgress[i].isRunning());
            }
        }
    }

    public static void saveGameProgress(LevelProgress[] progress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/game/controler/obj/game_progress.dat"))) {
            oos.writeObject(progress);
            System.out.println("Informações de progresso salvas com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LevelProgress[] createBlankGameProgress(){
        LevelProgress blanks[] = new LevelProgress[ Game.N_LEVELS ];
        for(int i = 0; i < Game.N_LEVELS; ++i){
            blanks[i] = new LevelProgress(1, false, false, 0);
        }
        return blanks;
    }

    public static LevelProgress[] loadGameProgress() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/game/controler/obj/game_progress.dat"))) {
            return (LevelProgress[]) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            LevelProgress blanks[] = createBlankGameProgress();
            saveGameProgress(blanks);
            return blanks;
        }
        return null;
    }
}
