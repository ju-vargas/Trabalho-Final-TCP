package src.com.game.view;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


import src.com.game.controler.Jogo;
import src.com.game.utils.style.Fonts;
import src.com.game.model.Level;

public class GameView extends JPanel implements ActionListener {
    private static int INTERVAL = 50; //o clock do jogo
    private Level level1 = new Level(1,2,3,Jogo.PATH_LEVEL1);
    private Fonts style = new Fonts(); 

    private boolean isRunning = false;

    Timer timer;
    private int miliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    Random random;
    
    public GameView() {
        random = new Random();
        setBackground(new Color(206, 206, 206));
        setPreferredSize(new Dimension(Jogo.WIDTH, Jogo.HEIGHT));
        setFocusable(true);
        addKeyListener(new GetKeyPressed());
    }

    public void startGameLevel() {
        isRunning = true;
        timer = new Timer(INTERVAL, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScreen(g);
    }

    public void drawScreen(Graphics g) {
        if (level1.isComplete()){
            System.out.println("ganhooooooooooooooooou");
        } 
        else if (level1.isEnd()) {
            fimDeJogo(g);
        } 
        else{
            level1.render(g);
            
            /*render HEADER */
            g.setColor(Color.red);
            g.setFont(style.regularTitle());
            FontMetrics metrics = getFontMetrics(g.getFont());

            int points = level1.getPlayer().getPoints();

            g.drawString("Pontos: " + points, (Jogo.WIDTH - metrics.stringWidth("Pontos: " + points)) / 2, g.getFont().getSize());
            g.drawString("Tempo: " + minutes + "min"  + seconds + "s", (Jogo.WIDTH - 2*metrics.stringWidth("Pontos: " + points)), g.getFont().getSize());
        }
    }

    public void fimDeJogo(Graphics g) {
        int points = level1.getPlayer().getPoints();

        g.setColor(Color.red);
        g.setFont(style.regularTitle());
        FontMetrics fontePontuacao = getFontMetrics(g.getFont());
        g.drawString("Pontos: " + points, (Jogo.WIDTH - fontePontuacao.stringWidth("Pontos: " + points)) / 2, g.getFont().getSize());
        g.setColor(Color.red);
        g.setFont(style.regularTitle());
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        g.drawString("\uD83D\uDE1D Fim do Jogo.", (Jogo.WIDTH - fonteFinal.stringWidth("Fim do Jogo")) / 2, Jogo.HEIGHT / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            level1.getPlayer().walk(); 
            if (!level1.isComplete())
                level1.setComplete(level1.checkScore());
            if (level1.isColliding()) 
                timer.stop();
            updateTimer();
        }
        repaint();
    }

    public class GetKeyPressed extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                level1.getPlayer().moveLeft();
                break;
                case KeyEvent.VK_RIGHT:
                level1.getPlayer().moveRight();
                break;
                case KeyEvent.VK_UP:
                level1.getPlayer().moveUp();
                break;
                case KeyEvent.VK_DOWN:
                level1.getPlayer().moveDown();
                break;
                default:
                break;
            }
        }
    }
    
    private void updateTimer(){
        miliseconds++;
        seconds = (int)miliseconds/(1000/INTERVAL);
        if (seconds % 60 == 0 && miliseconds % (1000/INTERVAL) == 0){
            minutes++;
            seconds = 0;
            miliseconds = 0;
        }
    }
    
}