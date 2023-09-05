package src.com.game.model;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
    private String idFase;
    private int numPoints;

    private boolean isComplete;
    private boolean isEnd;

    private LevelMap map;
    private Player player;
    private Point point;
    private PowerUp powerUp;
    private String songFile;

    private ArrayList<String> story;
    private String backgroundImageFile;

    public Level(String id, int numPowerUps, int numPoints, LevelMap map, String backgroundImageFile){
        this.idFase = id;
        this.numPoints = numPoints;
        this.map = map;
        this.songFile = null;
        this.player = new Player('D');
        this.backgroundImageFile = backgroundImageFile;
        setPointCoordinates(map.getRandomCoordinates());
        setPowerUpCoordinates(map.getRandomCoordinates());
        this.isEnd = false;
        this.isComplete = false;
    }

    public void setSongFile(String song){
        this.songFile = song;
    }

    public String getSongFile(){
        return songFile;
    }

    public void setStory(ArrayList<String> story){
        this.story = story;
    }

    public ArrayList<String> getStory(){
        return story;
    }

    public String getBackground(){
        return backgroundImageFile;
    }

    public void setPowerUpCoordinates(int[] coords){
       this.powerUp = new PowerUp(coords, 2, 3, "energy");
       map.setPowerUpCoordinates(coords);
    }

    public void setPointCoordinates(int[] coords){
       this.point = new Point(coords,1,"cafe");
       map.setPointCoordinates(coords);
    }

    public boolean isEnd(){
        return this.isEnd;
    }
    public boolean isComplete(){
        return this.isComplete;
    }
    public void setComplete(boolean complete){
        this.isComplete = complete;
    }
    public Player getPlayer(){
        return this.player;
    }
    public int getNumPoints(){
        return this.numPoints;
    }
    public LevelMap getMap(){
        return map;
    }
    public String getIdFase(){
        return this.idFase;
    }
    public boolean isColliding(){
        this.isEnd =  this.player.checkCollision(this.map.getMapConstraints(), this);
        return this.isEnd;
    }
    public void newPoint(){
        int coordinates[] = map.getRandomCoordinates();
        map.setPointCoordinates(coordinates);
        point.setCoordinates(coordinates);
    }
    public void newPowerUp(){
        int coordinates[] = map.getRandomCoordinates();
        map.setPowerUpCoordinates(coordinates);
        powerUp.setCoordinates(coordinates);
    }
    public boolean checkScore(){
        if (player.getPoints() == this.numPoints)
            return true;
        return false;
    }
    public void upScore(){
        Point.applyEffect(player);
        map.removeObject(point.getCoordinates());
        this.newPoint();
    }

    public void pickPowerup(){
        PowerUp.applyEffect(player);
        map.removeObject(powerUp.getCoordinates(), powerUp);
    }
    public void render(Graphics g, String labelRender){
        map.render(g);
        player.render(g, labelRender);
        point.render(g);
        if(powerUp.getCoordinates() != null){
            powerUp.render(g);
        }
    }
}
