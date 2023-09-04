package src.com.game.view;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import src.com.game.controler.Game;
import src.com.game.utils.style.Fonts;
import src.com.game.model.Level;
import src.com.game.controler.SaveLevel;
import src.com.game.controler.LevelProgress;
import src.com.game.controler.GameProgress;

public class GameView extends JPanel implements ActionListener {
    private static int INTERVAL = Game.STANDART_INTERVAL; //o clock do jogo
    private Level level;
    private Fonts style = new Fonts();

    private boolean isRunning = false;
    Timer timer = new Timer(INTERVAL, this);
    private Timer renderTimer; // Variável de classe para o Timer

    private double time = 0;
    private double miliseconds = 0;
    private double seconds = 0;
    private double minutes = 0;
    private boolean isAnyKeyPressed = false;
    Random random;
    private boolean nomeDecente = false;

    private int counterSprite = 0;
    private String labelRander = "";
    private String[] prefixRender = {
        "1",
        "2",
        "3",
        "4"
    };

    private BufferedImage backgroundImage;

    /*
     * muda o label a cada 1 segunda
     * concatena o label com o prefixo da direcao
     * manda pra renderizar
     */

    public GameView() {
        random = new Random();
        setBackground(new Color(206, 206, 206));
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setFocusable(true);
        addKeyListener(new GetKeyPressed());
        renderTimer();
    }

    public void startGameLevel(String id) {
        level = SaveLevel.loadLevel(id);
        isRunning = true;
        resetTimer();
        timer.start();
        renderTimer.restart();

        try {
            if( level.getSongFile() != null ){
                BufferedInputStream stream = new BufferedInputStream(new FileInputStream(level.getSongFile()) );
                AudioInputStream songStream = AudioSystem.getAudioInputStream( stream );
                Clip clip = AudioSystem.getClip();
                clip.open(songStream);
                clip.start();
            }

        } catch( Exception ex) {
            System.out.println("Não dá pra tocar audio... <"+level.getSongFile() + ">\n");
            System.out.println(ex);
            ex.printStackTrace();
        }

        LevelProgress[] timeProgress = GameProgress.loadGameProgress();
        int levelIndex = Integer.parseInt(id) - 1;
        if( timeProgress[ levelIndex ].isRunning()){
            time = timeProgress[levelIndex].getTime();
            seconds = (double) time;
            miliseconds = seconds*(1000/(INTERVAL));
            minutes = (int) seconds/(60000/(INTERVAL));
        }
        nomeDecente = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScreen(g);
    }

    public void renderTimer() {
        renderTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counterSprite < 3){
                    counterSprite++;
                }
                else
                    counterSprite = 0;
                labelRander = prefixRender[counterSprite];
            }
        });
    }

    public void drawScreen(Graphics g) {
        if (level.getPlayer().getSize() < Game.INICIAL_PLAYER_SIZE){
            level.getPlayer().increaseSize();
        }
        isAnyKeyPressed =  false;
        if (level.isComplete()){
            if(!nomeDecente){
                int thisIdInt = Integer.parseInt(level.getIdFase());
                LevelProgress[] loadedProgress = GameProgress.loadGameProgress();
                time = seconds + minutes*60;
                loadedProgress[ thisIdInt - 1 ] = new LevelProgress(thisIdInt, true, false, (int) time);
                GameProgress.saveGameProgress(loadedProgress);

                // If finished the game
                if( thisIdInt == Game.N_LEVELS ){
                    Game.gameScreen.changeScreenWin();
                } else {
                    Game.gameScreen.changeScreenLevel();
                }
                nomeDecente = true;
            }
            // SaveLevel.saveLevel(level, level.getIdFase());
            resetTimer();
            isRunning = false;
        }
        else if (level.isEnd()) {
            if(!nomeDecente){
                // Reseta o progresso da fase se o jogador perdeu
                GameProgress.clearGameProgress(Integer.parseInt( level.getIdFase() ));
                Level newLevel = Game.levelLoader.getLevel(level.getIdFase());
                SaveLevel.saveLevel(newLevel, level.getIdFase());
                Game.gameScreen.changeScreenDead();
                nomeDecente = true;
            }
        }
        else{
            String pathBackground = level.getBackground();

            try {
                backgroundImage = ImageIO.read(new File(pathBackground)); // Substitua "background.jpg" pelo caminho da sua imagem
            } catch (IOException e) {
                System.out.println("Tentou ler a imagem no caminho <" + pathBackground +">");
                e.printStackTrace();
            }

            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            level.render(g, labelRander);

            g.setColor(Color.BLACK);
            g.setFont(style.regularTitle());
            FontMetrics metrics = getFontMetrics(g.getFont());

            int points = level.getPlayer().getPoints();

            g.drawString("Pontos: " + points, (Game.WIDTH - 300 - metrics.stringWidth("Pontos: " + points)) / 2, g.getFont().getSize());
            g.drawString("Tempo: " + minutes + "min"  + (new DecimalFormat("#,##0.00").format(seconds)) + "s", (Game.WIDTH - 300 - 2*metrics.stringWidth("Pontos: " + points)), g.getFont().getSize());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            int newDelay = (int) Math.round(INTERVAL / level.getPlayer().getSpeed());
            timer.setDelay(newDelay);
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
                if(!nomeDecente){

                    int thisIdInt = Integer.parseInt(level.getIdFase());
                    LevelProgress[] loadedProgress = GameProgress.loadGameProgress();
                    time = seconds + minutes*60;
                    loadedProgress[ thisIdInt - 1 ] = new LevelProgress(thisIdInt, false, true, (int) time);
                    GameProgress.saveGameProgress(loadedProgress);
                    SaveLevel.saveLevel(level, level.getIdFase());
                    GameProgress.printGameProgress();
                    Game.gameScreen.changeScreenLevel();
                    nomeDecente = true;
                    resetTimer();
                    isRunning = false;
                }
            }
        }
    }

    private void resetTimer(){
        miliseconds = 0;
        seconds = 0;
        minutes = 0;
    }

    private void updateTimer(){
        miliseconds = miliseconds + ((double) 1 / level.getPlayer().getSpeed());
        time = time + ((double) 1 / level.getPlayer().getSpeed());
        seconds = (double) miliseconds/(1000/(INTERVAL));
        if (seconds > 60){
            minutes++;
            seconds = 0;
            miliseconds = 0;
        }
    }

}