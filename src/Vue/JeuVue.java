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
    private final int PANEL_HEIGHT = 675;
    private JeuMenuBar jeuMenuBar = new JeuMenuBar();
    private JLabel timerLabel;
    private MessageNotification messageNotification = new MessageNotification();
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

        timerLabel = new JLabel("Time:0");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(new BorderLayout());
        panel.add(vueCartes, BorderLayout.CENTER);
        panel.add(timerLabel,BorderLayout.SOUTH);
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



    public void aboutMessage(){
        String message = "Jeu de Mémoire\n\nVersion 0.2\n\n© 2023 SHANG LI";
        messageNotification.showMessage(this,"À propos",message);
    }


    public void instructionMessage(){
        String message = "C'est un jeu de mémoire où vous devez retourner les cartes.\n" +
                "Au début du jeu, toutes les cartes sont face cachée.\n" +
                "Vous devez retourner deux cartes à la fois.\n" +
                "Si les deux cartes ont le même image, vous pouvez les conserver.\n" +
                "Sinon, vous devez les retourner face cachée à nouveau.\n" +
                "L'objectif du jeu est de retourner toutes les cartes en trouvant les paires correspondantes.\n" +
                "Bonne chance !";
        messageNotification.showMessage(this,"Instructions",message);
    }


    public JeuMenuBar getJeuMenuBar() {
        return jeuMenuBar;
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }


}
