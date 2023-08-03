import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUm extends JPanel {
	JButton switchToPanel2 = new JButton("Ir para a Tela 2");

	TelaUm() {
        setBackground(Color.BLUE);
        setFocusable(true);
		
		switchToPanel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogo.cardLayout.show(Jogo.cardPanel, Jogo.TELA_DOIS);
			}
		});

		add(switchToPanel2);
    }
}
