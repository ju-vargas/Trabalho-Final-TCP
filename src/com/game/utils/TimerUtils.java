package src.com.game.utils;

public class TimerUtils {
    public static int[] getTimeComponents(int time){
        int minutes = (int) time/60;
        int seconds = time - minutes * 60;
        int timeComponents[] = {minutes, seconds};

        return timeComponents;
    }

    public static int[] sum(int timeA[], int timeB[]){
        int secondsOverflow = 0;
        int seconds = timeA[1] + timeB[1];
        if (seconds > 60){
            seconds -= 60;
            secondsOverflow++;
        }
        int minutes = timeA[0] + timeB[0] + secondsOverflow;
        int timeComponents[] = {minutes, seconds};

        return timeComponents;
    }
}
