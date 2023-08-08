import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TelaJogo extends JPanel implements ActionListener {

    private static final int LARGURA_TELA = 1280;
    private static final int ALTURA_TELA = 720;
    private static final int MAX_HEIGHT = 720 - Jogo.WINDOW_HEIGHT_DIFFERENCE;
    private static final int MAX_WIDTH = 1280 - Jogo.WINDOW_WIDTH_DIFFERENCE;
    private static final int TAMANHO_BLOCO = 20;
    private static final int UNIDADES = LARGURA_TELA * ALTURA_TELA / (TAMANHO_BLOCO * TAMANHO_BLOCO); //qts unidades tem na cobrinha
    private static final int INTERVALO = 50; //o clock do jogo
    private static final String NOME_FONTE = "Ink Free";
    private final int[] bodyX = new int[UNIDADES]; //fazem parte do corpo da cobra
    private final int[] bodyY = new int[UNIDADES]; //fazem parte do corpo da cobra
    private final int XBlocks = 63; //tamanho máximo de blocos no grid no eixo x
    private final int YBlocks = 31; //tamanho máximo de blocos no grid no eixo x
    private final int[][]mapa = new int[XBlocks][YBlocks];
    private int tamanhoJogador = 6; //tamanho inicial
    private int pontuacao;
    private int pontuacaoFase = 2;
    private int[] randomPosition = new int[2];
    private char direcao = 'D'; // C - Cima, B - Baixo, E - Esquerda, D - Direita
    private boolean estaRodando = false;
    Timer timer;
    private int miliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    Random random;
    private boolean win = false;

    public Fonts style = new Fonts(); 

    TelaJogo() {
        random = new Random();
        setBackground(new Color(206, 206, 206));
        setPreferredSize(new Dimension(Jogo.WIDTH, Jogo.HEIGHT));
        setFocusable(true);
        addKeyListener(new LeitorDeTeclasAdapter());
        iniciarJogo();
    }

    public void iniciarJogo() {
        getRandomCoordinates();
        estaRodando = true;
        timer = new Timer(INTERVALO, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharTela(g);
    }

    public void desenharTela(Graphics g) {
        if (estaRodando) {   
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    int blockID = mapa[i][j];

                    switch (blockID){
                        case 0 :
                            g.setColor(new Color(((i*1) % 255), (i*2) % 255, (i*1) % 255));
                            break;
                        case 1:
                            g.setColor(new Color(255, 0, 0));
                            break;
                        }
                        
                    g.fillRect(i*TAMANHO_BLOCO, 60+j*TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
            }
            g.setColor(Color.green);
            g.fillOval(randomPosition[0], randomPosition[1], TAMANHO_BLOCO, TAMANHO_BLOCO);

            for (int i = 0; i < tamanhoJogador; i++) {
                if (i == 0) {
                    g.setColor(new Color(223, 113, 37));
                    g.fillRect(bodyX[0], bodyY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
                } else {
                    g.setColor(new Color(214, 154, 58));
                    g.fillRect(bodyX[i], bodyY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
            }

            g.setColor(Color.red);
            g.setFont(new Font(NOME_FONTE, Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Pontos: " + pontuacao, (LARGURA_TELA - metrics.stringWidth("Pontos: " + pontuacao)) / 2, g.getFont().getSize());
            g.drawString("Tempo: " + minutes + "min"  + seconds + "s", (LARGURA_TELA - 2*metrics.stringWidth("Pontos: " + pontuacao)), g.getFont().getSize());
        } else if (win){
            //tela de win aqui
            System.out.println("ganhooooooooooooooooou");
        }else {
            fimDeJogo(g);
        }
    }

    private void getRandomCoordinates() {
        boolean validPosition = false;
        int randomX;
        int randomY;
        do{
            randomX = random.nextInt(XBlocks-1);
            randomY = random.nextInt(YBlocks-1);
            validPosition = mapa[randomX][randomY] == 0 ? true : false;
        }while(!validPosition);

        randomPosition[0] = randomX*TAMANHO_BLOCO;
        randomPosition[1] = 60+randomY*TAMANHO_BLOCO;
    }

    public void fimDeJogo(Graphics g) {
        g.setColor(Color.red);
        g.setFont(style.fontScreenWin());
        FontMetrics fontePontuacao = getFontMetrics(g.getFont());
        g.drawString("Pontos: " + pontuacao, (LARGURA_TELA - fontePontuacao.stringWidth("Pontos: " + pontuacao)) / 2, g.getFont().getSize());
        g.setColor(Color.red);
        g.setFont(style.fontScreenWin());
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        g.drawString("\uD83D\uDE1D Fim do Jogo.", (LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 2, ALTURA_TELA / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if (estaRodando) {
            andar();
            alcancarBloco();
            validarLimites();
            updateTimer();
        }
        repaint();
    }

    private void updateTimer(){
        miliseconds++;
        seconds = (int)miliseconds/(1000/INTERVALO);
        if (seconds % 60 == 0 && miliseconds % (1000/INTERVALO) == 0){
            minutes++;
            seconds = 0;
            miliseconds = 0;
        }
    }

    private void andar() {
        for (int i = tamanhoJogador; i > 0; i--) {
            bodyX[i] = bodyX[i - 1];
            bodyY[i] = bodyY[i - 1];
        }

        switch (direcao) {
            case 'C':
                bodyY[0] = bodyY[0] - TAMANHO_BLOCO;
                break;
            case 'B':
                bodyY[0] = bodyY[0] + TAMANHO_BLOCO;
                break;
            case 'E':
                bodyX[0] = bodyX[0] - TAMANHO_BLOCO;
                break;
            case 'D':
                bodyX[0] = bodyX[0] + TAMANHO_BLOCO;
                break;
            default:
                break;
        }
    }

    private void alcancarBloco() {
        if (bodyX[0] == randomPosition[0] && bodyY[0] == randomPosition[1]) {
            tamanhoJogador++;
            pontuacao++;
            if (pontuacao == pontuacaoFase){
                win = true;
                estaRodando = false;
            }
            getRandomCoordinates();
        }
    }

    private void validarLimites() {
        //A cabeça bateu no corpo?
        for (int i = tamanhoJogador; i > 0; i--) {
            if (bodyX[0] == bodyX[i] && bodyY[0] == bodyY[i]) {
                estaRodando = false;
                break;
            }
        }

        //A cabeça tocou uma das bordas Direita ou esquerda?
        if (bodyX[0] < 0 || bodyX[0] > MAX_WIDTH) {
            estaRodando = false;
        }

        //A cabeça tocou o piso ou o teto?
        if (bodyY[0] < 0 || bodyY[0] > MAX_HEIGHT) {
            estaRodando = false;
        }

        if (!estaRodando) {
            timer.stop();
        }
    }

    public class LeitorDeTeclasAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direcao != 'D') {
                        direcao = 'E';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direcao != 'E') {
                        direcao = 'D';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direcao != 'B') {
                        direcao = 'C';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direcao != 'C') {
                        direcao = 'B';
                    }
                    break;
                default:
                    break;
            }
        }
    }
}