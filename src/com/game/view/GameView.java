package src.com.game.view;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Random;


import src.com.game.controler.Jogo;
import src.com.game.utils.style.Fonts;
import src.com.game.model.Level;
import src.com.game.controler.SaveLevel;
import src.com.game.controler.LevelProgress;
import src.com.game.controler.GameProgress;
/*
 * se isRunning, eu procuro o arquivo
 * se nao eu crio um novo em cima, ou novo jogo
 * pq isCompleted cria novo jogo
 * preciso lembrar de reescrever as informacoes quando acabar
 */


public class GameView extends JPanel implements ActionListener {
    private static int INTERVAL = 40; //o clock do jogo
    //private Level level = new Level(1,2,3,Jogo.PATH_LEVEL1);
    private Level level; 
    private Fonts style = new Fonts(); 

    private boolean isRunning = false;
    Timer timer = new Timer(INTERVAL, this);
    private double miliseconds = 0;
    private double seconds = 0;
    private int minutes = 0;
    private boolean isAnyKeyPressed = false;
    Random random;
    
    public GameView() {
        random = new Random();
        setBackground(new Color(206, 206, 206));
        setPreferredSize(new Dimension(Jogo.WIDTH, Jogo.HEIGHT));
        setFocusable(true);
        addKeyListener(new GetKeyPressed());
    }

    public void startGameLevel(String id) {   
        level = SaveLevel.loadLevel(id);
        isRunning = true;
        resetTimer();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScreen(g);
    }

    public void drawScreen(Graphics g) {
        if (level.getPlayer().getSize() < Jogo.INICIAL_PLAYER_SIZE){
            level.getPlayer().increaseSize();
        }
        isAnyKeyPressed =  false;
        if (level.isComplete()){
            LevelProgress[] loadedProgress = GameProgress.loadGameProgress();
            LevelProgress thisLevelProgress;
            switch(level.getIdFase()){
                case "1":
                    thisLevelProgress = new LevelProgress(1, true, false, (int) miliseconds); 
                    GameProgress.saveGameProgress(thisLevelProgress, loadedProgress[1]);
                    SaveLevel.saveLevel(level, level.getIdFase());      
                    Jogo.gameScreen.changeScreenLevel();
                    break;
                case "2":
                    thisLevelProgress = new LevelProgress(2, true, false, (int) miliseconds); 
                    GameProgress.saveGameProgress(loadedProgress[0], thisLevelProgress);
                    SaveLevel.saveLevel(level, level.getIdFase());      
                    Jogo.gameScreen.changeScreenWin();
                    break;
            }
            // SaveLevel.saveLevel(level, level.getIdFase());   
            resetTimer();
            isRunning = false;
        } 
        else if (level.isEnd()) {
            switch(level.getIdFase()){
                case "1":
                    GameProgress.clearGameProgress(1);
                    Level level1 = new Level("1",2,3,Jogo.PATH_LEVEL1);
                    SaveLevel.saveLevel(level1,"1");
                    break; 
                case "2":
                    GameProgress.clearGameProgress(2);
                    Level level2 = new Level("2",2,3,Jogo.PATH_LEVEL2);
                    SaveLevel.saveLevel(level2,"2");
            }
            Jogo.gameScreen.changeScreenDead();
        } 
        else{
            level.render(g);
            
            /*render HEADER */
            g.setColor(Color.red);
            g.setFont(style.regularTitle());
            FontMetrics metrics = getFontMetrics(g.getFont());

            int points = level.getPlayer().getPoints();

            g.drawString("Pontos: " + points, (Jogo.WIDTH - 300 - metrics.stringWidth("Pontos: " + points)) / 2, g.getFont().getSize());
            g.drawString("Tempo: " + minutes + "min"  + seconds + "s", (Jogo.WIDTH - 300 - 2*metrics.stringWidth("Pontos: " + points)), g.getFont().getSize());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            timer.setDelay(INTERVAL * level.getPlayer().getSpeed());
            level.getPlayer().walk(); 
            if (level.getPlayer().isSpeededUp()){
                if (checkEndOfSpeedUp(level.getPlayer())){
                    level.getPlayer().speedDown();
                    level.newPowerUp();
                }
            }
            if (!level.isComplete())
                level.setComplete(level.checkScore());
            if (level.isColliding()) 
                timer.stop();
            updateTimer();
        }
        repaint();
    }

    private boolean checkEndOfSpeedUp(src.com.game.model.Player player){
        int minutes = LocalDateTime.now().getMinute();
        int seconds = LocalDateTime.now().getSecond();

        LocalDateTime endTime = player.getEndSpeedUpTime();
        if(endTime.getMinute() <= minutes){
            if (endTime.getSecond() <= seconds){
                return true;
            }
        }
        return false;
    }

    public class GetKeyPressed extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (!isAnyKeyPressed){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        level.getPlayer().moveLeft();                     
                        isAnyKeyPressed = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        level.getPlayer().moveRight();
                        isAnyKeyPressed = true;                   
                        break;
                    case KeyEvent.VK_UP:
                        level.getPlayer().moveUp();
                        isAnyKeyPressed = true;                   
                        break;
                    case KeyEvent.VK_DOWN:
                        level.getPlayer().moveDown();
                        isAnyKeyPressed = true;                   
                        break;
                    default:
                        isAnyKeyPressed = false;
                        break;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                Jogo.gameScreen.goTo(Jogo.mapaScreen);
                resetTimer();
                isRunning = false;
            }
        }
    }

    private void resetTimer(){
        miliseconds = 0;
        seconds = 0;
        minutes = 0;
    }
    
    private void updateTimer(){
        miliseconds = miliseconds + ((double) 1 * level.getPlayer().getSpeed());
        seconds = (double) miliseconds/(1000/(INTERVAL));
        if (seconds % 60 == 0 && miliseconds % (1000/INTERVAL) == 0){
            minutes++;
            seconds = 0;
            miliseconds = 0;
        }
    }
    
}