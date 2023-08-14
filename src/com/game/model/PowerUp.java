package src.com.game.model;

import java.time.LocalDateTime;

public class PowerUp extends LevelMapObject{   
    private static int speedValue = 0;
    private static int speedUpDuration = 0;
    
    public PowerUp(int[] coord, int speedValue, int speedUpDuration, String imageName){
        super(coord, imageName);
        PowerUp.speedValue = speedValue;
        PowerUp.speedUpDuration = speedUpDuration;
    }

    public static void applyEffect(Player player){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime newTime = currentTime.plusSeconds(speedUpDuration);
        player.speedUp(speedValue);
        player.setEndSpeedUpTime(newTime);
    }
}
