package src.com.game.controler;

import java.io.Serializable;

public class LevelProgress implements Serializable {
    private int id; 
    private boolean isCompleted;
    private boolean isGameRunning; 
    private int time;

    public LevelProgress(int id, boolean isCompleted, boolean isRunning, int time) {
        this.isCompleted = isCompleted;
        this.isGameRunning = isRunning;
        this.time = time;
        this.id = id;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public int getTime() {
        return this.time;

    }

    public boolean isRunning() {
        return this.isGameRunning;
    }
    public int getId() {
        return this.id;
    }
}
 