package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Classe représentant un panneau de notification de victoire.
 */
public class VictoryNotificationPanel extends JPanel {
    /**
     * Constructeur pour la classe VictoryNotificationPanel.
     *
     * @param layeredPane Le panneau à plusieurs couches contenant les éléments graphiques.
     * @param onReplayClicked L'action à effectuer lorsque l'utilisateur clique sur "Rejouer".
     */
    public VictoryNotificationPanel(JLayeredPane layeredPane, Runnable onReplayClicked) {

        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        JLabel victoryLabel = new JLabel("GAGNÉ!");
        victoryLabel.setFont(new Font("Georgia", Font.BOLD, 60));
        victoryLabel.setForeground(Color.YELLOW);

        add(victoryLabel, gridBagConstraints);

        JLabel playAgainLabel = new JLabel("Rejouer?");
        gridBagConstraints.gridy = 1;

        playAgainLabel.setForeground(Color.WHITE);
        playAgainLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        playAgainLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        playAgainLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               onReplayClicked.run();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                playAgainLabel.setForeground(Color.ORANGE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                playAgainLabel.setForeground(Color.WHITE);
            }

        });

        add(playAgainLabel, gridBagConstraints);
    }

    /**
     * Méthode pour dessiner les composants graphiques du panneau.
     *
     * @param g L'objet Graphics pour dessiner les composants.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 128));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
