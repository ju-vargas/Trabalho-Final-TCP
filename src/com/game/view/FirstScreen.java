package src.com.game.view;
import javax.swing.*;

import src.com.game.controler.Jogo;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen extends JPanel {
	JButton switchToPanel2 = new JButton("Ir para a Tela 2");

	public FirstScreen() {
        setBackground(Color.BLUE);
        setFocusable(true);
		
		switchToPanel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogo.cardLayout.show(Jogo.cardPanel, Jogo.SECOND_SCREEN);
			}
		});

		add(switchToPanel2);
    }
}
