package src.com.game.model;
import java.awt.*;
import java.io.Serializable;

public class Level implements Serializable {
    private String idFase;
    private int numPoints;
    
    private boolean isComplete;
    private boolean isEnd; 
    
    private LevelMap map; 
    private Player player;
    private Point point;
    private PowerUp powerUp;

    /*
     * possivelmente nesse construtor aqui
     * que vai ser o gerencialmente de continue e tal 
     */
    public Level(String id, int numPoints, String path){
        this.idFase = id;
        this.numPoints = numPoints; 
        this.map = new LevelMap(id, path);
        this.player = new Player('D');
        this.point = new Point(new int[2],1,"cafe");
    }

    public Level(String id, int numPowerUps, int numPoints, String path){
       this.idFase = id;
       this.numPoints = numPoints; 
       this.map = new LevelMap(id, path);
       this.player = new Player('D');
       this.point = new Point(map.getRandomCoordinates(),1,"cafe");
       map.setPointCoordinates(point.getCoordinates());
       this.powerUp = new PowerUp(map.getRandomCoordinates(), 2, 3, "energy");
       map.setPowerUpCoordinates(powerUp.getCoordinates());
       this.isEnd = false;
       this.isComplete = false; 
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
