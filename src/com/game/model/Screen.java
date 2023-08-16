package src.com.game.model;
import javax.swing.*;

import src.com.game.controler.Game;
import src.com.game.utils.ScreenUtils;

public abstract class Screen extends JFrame {

	private ScreenUtils telaUtils = new ScreenUtils();

	public Screen(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Game.WIDTH, Game.HEIGHT);
	}

	public ScreenUtils getTelaUtils() {
		return telaUtils;
	}

	public void setTelaUtils(ScreenUtils telaUtils) {
		this.telaUtils = telaUtils;
	}

	public void goTo(JFrame destination){
		telaUtils.irDePara(this, destination);
	}
}
