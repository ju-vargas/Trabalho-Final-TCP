package src.com.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaOpcoes extends JFrame {
    public TelaOpcoes() {
        // Configurações da janela
        setTitle("Tela Inicial do Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		GridBagConstraints duvidei = new GridBagConstraints();

        // Título na parte de cima
        JLabel tituloLabel = new JLabel("DOGBYTE");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 50));
        tituloLabel.setBounds(180, 100, 900, 200);
		
		duvidei.gridx = 0;
		duvidei.gridy = 0;
        add(tituloLabel, duvidei);


        // Botões na parte inferior
        JPanel painelBotoes = new JPanel(new FlowLayout());
		painelBotoes.setFont(new Font("Arial", Font.BOLD, 20));
        JButton botao1 = new JButton("Novo Jogo");
        JButton botao2 = new JButton("Continuar");
        JButton botao3 = new JButton("Ranking");
        JButton botao4 = new JButton("Regras");
		JButton botaoSair = new JButton("Sair");

        painelBotoes.add(botao1);
        painelBotoes.add(botao2);
        painelBotoes.add(botao3);
        painelBotoes.add(botao4);
		painelBotoes.add(botaoSair);
        
        //painelBotoes.setLocation(100, 400);
		duvidei.gridx = 0;
		duvidei.gridy = 1;
		
        add(painelBotoes,duvidei);

		

		botaoSair.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});

		

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaOpcoes tela = new TelaOpcoes();
            tela.setVisible(true);
        });
    }
}

