import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlassPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Glass Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JRootPane rootPane = new JRootPane();
        frame.setContentPane(rootPane);

        JPanel contentPane = new JPanel(new BorderLayout());
        rootPane.setContentPane(contentPane);

        JLabel label = new JLabel("Clique no botão para ativar o Glass Pane");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);

        JButton glassPaneButton = new JButton("Ativar Glass Pane");
        contentPane.add(glassPaneButton, BorderLayout.SOUTH);

        JPanel glassPane = new JPanel();
        glassPane.setOpaque(true);
        glassPane.setLayout(new GridBagLayout());
        glassPane.setBackground(new Color(0,0,0,100));
        JLabel glassLabel = new JLabel("Glass Pane Ativado");
        glassLabel.setForeground(Color.WHITE);
        glassPane.add(glassLabel);

        frame.setGlassPane(glassPane);

        glassPaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isGlassPaneVisible = frame.getGlassPane().isVisible();
                frame.getGlassPane().setVisible(!isGlassPaneVisible);
                glassPaneButton.setText(isGlassPaneVisible ? "Ativar Glass Pane" : "Desativar Glass Pane");
            }
        });

        frame.setVisible(true);
    }
}