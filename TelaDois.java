import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDois extends JPanel {
	JButton switchToPanel1 = new JButton("Ir para a Tela 1");

	TelaDois() {
        setBackground(Color.RED);
        setFocusable(true);
		
		switchToPanel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogo.cardLayout.show(Jogo.cardPanel, Jogo.TELA_UM);
			}
		});

		add(switchToPanel1);
    }
}