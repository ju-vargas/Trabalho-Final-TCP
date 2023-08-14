package src.com.game.model;
import java.awt.*;
import java.io.Serializable;

import src.com.game.model.LevelMap;
import src.com.game.model.Player;
import src.com.game.model.Point;

public class Level implements Serializable {
    private String idFase;
    private int numPoints;
    
    private boolean isComplete;
    private boolean isEnd; 
    
    private LevelMap map; 
    private Player player;
    private Point point;

    /*
     * possivelmente nesse construtor aqui
     * que vai ser o gerencialmente de continue e tal 
     */
    public Level(String id, int numPowerUps, int numPoints, String path){
       this.idFase = id;
       this.numPoints = numPoints; 
       this.map = new LevelMap(id, path);
       this.player = new Player('D');
       this.point = new Point(map.getRandomCoordinates());
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
        this.isEnd =  this.player.checkCollision(this.map.getMapConstraints());
        return this.isEnd;
    }
    public void newPoint(){
        point.setPosition(map.getRandomCoordinates());
    }
    public boolean checkScore(){
        if(player.madePoint(point.getPosition())){
            if (player.getPoints() == this.numPoints)
            return true; 
            this.newPoint();
        }
        return false;
    }
    public void render(Graphics g){
        map.render(g);
        player.render(g);
        point.render(g);
    }
}
