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
    private static final int TAMANHO_BLOCO = 20;
    private static final int UNIDADES = LARGURA_TELA * ALTURA_TELA / (TAMANHO_BLOCO * TAMANHO_BLOCO); //qts unidades tem no grid
    private static final int INTERVALO = 50; //o clock do jogo
    private static final String NOME_FONTE = "Ink Free";
    private final int[] eixoX = new int[UNIDADES]; //fazem parte do corpo da cobra
    private final int[] eixoY = new int[UNIDADES]; //fazem parte do corpo da cobra
    private int tamanhoJogador = 6; //tamanho inicial
    private int pontuacao;
    private int blocoX;
    private int blocoY;
    private char direcao = 'D'; // C - Cima, B - Baixo, E - Esquerda, D - Direita
    private boolean estaRodando = false;
    Timer timer;
    Random random;

    public Fonts style = new Fonts(); 

    TelaJogo() {
        random = new Random();
        setBackground(new Color(206, 206, 206));
        setFocusable(true);
        addKeyListener(new LeitorDeTeclasAdapter());
        iniciarJogo();
    }

    public void iniciarJogo() {
        criarBloco();
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
        //System.out.println(timer.toString());
        System.out.println(ALTURA_TELA);
        if (estaRodando) {
            for (int i = 0; i < ALTURA_TELA/TAMANHO_BLOCO; i++) {
                for (int j = 0; j < LARGURA_TELA/TAMANHO_BLOCO; j++) {
                    g.setColor(new Color(((i*1) % 255), (i*2) % 255, (i*3) % 255));
                    g.fillRect(TAMANHO_BLOCO*j, TAMANHO_BLOCO*i, TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
            }
            // g.setColor(Color.red);
            // g.fillOval(blocoX, blocoY, TAMANHO_BLOCO, TAMANHO_BLOCO);
            // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);


            // for (int i = 0; i < tamanhoJogador; i++) {
            //     if (i == 0) {
            //         g.setColor(new Color(223, 113, 37));
            //         g.fillRect(eixoX[0], eixoY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
            //     } else {
            //         g.setColor(new Color(214, 154, 58));
            //         g.fillRect(eixoX[i], eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
            //     }
            // }
            // g.setColor(Color.red);
            // g.setFont(new Font(NOME_FONTE, Font.BOLD, 40));
            // FontMetrics metrics = getFontMetrics(g.getFont());
            // g.drawString("Pontos: " + pontuacao, (LARGURA_TELA - metrics.stringWidth("Pontos: " + pontuacao)) / 2, g.getFont().getSize());
        } else {
            fimDeJogo(g);
        }
    }

    private void criarBloco() {
        blocoX = random.nextInt(LARGURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
        blocoY = random.nextInt(ALTURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
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
            //andar();
            //alcancarBloco();
            //validarLimites();
        }
        repaint();
    }

    private void andar() {
        for (int i = tamanhoJogador; i > 0; i--) {
            eixoX[i] = eixoX[i - 1];
            eixoY[i] = eixoY[i - 1];
        }

        switch (direcao) {
            case 'C':
                eixoY[0] = eixoY[0] - TAMANHO_BLOCO;
                break;
            case 'B':
                eixoY[0] = eixoY[0] + TAMANHO_BLOCO;
                break;
            case 'E':
                eixoX[0] = eixoX[0] - TAMANHO_BLOCO;
                break;
            case 'D':
                eixoX[0] = eixoX[0] + TAMANHO_BLOCO;
                break;
            default:
                break;
        }
    }

    private void alcancarBloco() {
        if (eixoX[0] == blocoX && eixoY[0] == blocoY) {
            tamanhoJogador++;
            pontuacao++;
            criarBloco();
        }
    }

    private void validarLimites() {
        //A cabeça bateu no corpo?
        for (int i = tamanhoJogador; i > 0; i--) {
            if (eixoX[0] == eixoX[i] && eixoY[0] == eixoY[i]) {
                estaRodando = false;
                break;
            }
        }

        //A cabeça tocou uma das bordas Direita ou esquerda?
        if (eixoX[0] < 0 || eixoX[0] > LARGURA_TELA) {
            estaRodando = false;
        }

        //A cabeça tocou o piso ou o teto?
        if (eixoY[0] < 0 || eixoY[0] > ALTURA_TELA) {
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