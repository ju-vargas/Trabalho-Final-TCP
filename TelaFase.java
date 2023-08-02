import javax.swing.*;
import java.awt.*;


public class TelaFase extends Tela {

    private JFrame janela;
	private JButton botaoJanelaFase;
    private Fase faseAtual;
	private final int WIDTH = 800;
	private final int HEIGHT = 600;

    public TelaFase(Fase fase) {
        this.faseAtual = fase;

        // Crie a janela do JFrame
        //janelaPrincipal = new JFrame("Tela da Fase");
        //janelaPrincipal.setSize(WIDTH, HEIGHT);
        //janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicione os componentes gráficos da fase à janela, como botões, painéis etc.
        // Por exemplo:
        // JPanel painel = new JPanel();
        // painel.add(new JButton("Botão da Fase"));
        // janela.add(painel);

        //janelaPrincipal.setVisible(true);
    }

    public Fase getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(Fase faseAtual) {
        this.faseAtual = faseAtual;
    }
    
    // Se você quiser criar uma tela de vitória, pode fazer isso como um método separado
    public void exibirTelaVitoria() {

		janela = new JFrame("Tela da Fase");
		configuraJanela(janela);

		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel textoVitoria = new JLabel("Parabéns, você passou de Fase!");
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
	
		JButton botaoVitoria = criaBotaoFase("Continuar");

		painel.add(textoVitoria);
        painel.add(botaoVitoria);
		
		janela.add(painel);


        janela.setVisible(true);
    }

	public void exibirTelaMorte() {

	}

	public void exibirTelaIntroducao() {

	}

	public void configuraJanela(JFrame janela) {
        janela.setSize(WIDTH, HEIGHT);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton criaBotaoFase(String textoBotao){
		JButton botao = new JButton();
		botao.setSize(10, 50);
        botao.add(new JButton(textoBotao));

		return botao;
	}
}
