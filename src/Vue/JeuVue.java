package Vue;

import Controleur.JeuControlleur;

import javax.swing.*;
import java.awt.*;

/**
 * Classe représentant la vue du jeu de mémoire.
 */
public class JeuVue extends JFrame {

    private DefaultListModel<Object> modelVueCartes;
    private JList<Object> vueCartes;
    private final int PANEL_WIDTH = 780;
    private final int PANEL_HEIGHT = 650;
    private JeuMenuBar jeuMenuBar = new JeuMenuBar();
    public static final Color COULEUR_VERSO = new Color(61, 47, 148);

    /**
     * Constructeur par défaut pour la classe JeuVue.
     */
    public JeuVue() {

        modelVueCartes = new DefaultListModel<>();
        vueCartes = new JList<>(modelVueCartes);
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel panel = new JPanel();

        vueCartes.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        vueCartes.setVisibleRowCount(4);
        vueCartes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vueCartes.setFixedCellWidth(156);
        vueCartes.setFixedCellHeight(156);
        vueCartes.setCellRenderer(new CarteCellRenderer());

        JLabel gameTimer = new JLabel("test timer");

//        panel.setLayout(new BorderLayout());
        panel.add(vueCartes, BorderLayout.CENTER);
//        panel.add(gameTimer,BorderLayout.SOUTH);
        panel.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        layeredPane.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);


        setTitle("Jeu de Mémoire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(layeredPane);
        this.setJMenuBar(jeuMenuBar);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Getter pour obtenir la vue des cartes.
     *
     * @return La vue des cartes.
     */
    public JList<Object> getVueCartes() {
        return vueCartes;
    }

    /**
     * Getter pour obtenir le modèle de la vue des cartes.
     *
     * @return Le modèle de la vue des cartes.
     */
    public DefaultListModel<Object> getModelVueCartes() {
        return modelVueCartes;
    }

    /**
     * Méthode pour afficher la vue.
     */
    public void showVue() {
        setVisible(true);
    }

    /**
     * Méthode pour commencer une nouvelle partie.
     */
    public void nouvellePartie() {
        modelVueCartes.clear();

    }

    /**
     * Méthode pour afficher la notification de victoire.
     *
     * @param layeredPane Le panneau à plusieurs couches contenant les éléments graphiques.
     * @param controlleur Le contrôleur du jeu.
     */
    public void showVictoryNotification(JLayeredPane layeredPane, JeuControlleur controlleur) {
        VictoryNotificationPanel notificationPanel = new VictoryNotificationPanel(layeredPane, () -> {
            controlleur.rejouer();
        });
        notificationPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        layeredPane.add(notificationPanel, JLayeredPane.POPUP_LAYER);
    }





    public JeuMenuBar getJeuMenuBar() {
        return jeuMenuBar;
    }


}
