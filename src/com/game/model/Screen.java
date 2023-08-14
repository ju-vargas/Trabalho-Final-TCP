package src.com.game.model;
import javax.swing.*;

import src.com.game.controler.Jogo;
import src.com.game.utils.TelaUtils;

public class Screen extends JFrame {

	private TelaUtils telaUtils = new TelaUtils();

	private int altura;

	private int largura;

	public void abrir() {

	}

	public void fechar() {

	}

	public void teclaDigitada() {

	}

	public void teclaPressionada() {

	}

	public void teclaSolta() {

	}

	public Screen(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Jogo.WIDTH, Jogo.HEIGHT);
	}

	public TelaUtils getTelaUtils() {
		return telaUtils;
	}

	public void setTelaUtils(TelaUtils telaUtils) {
		this.telaUtils = telaUtils;
	}

	public void goTo(JFrame destination){
		telaUtils.irDePara(this, destination);
	}
}
