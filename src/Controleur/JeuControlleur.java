package Controleur;

import Modele.JeuMemoire;
import Vue.JeuVue;
import Vue.VictoryNotificationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour gérer la logique du jeu et la coordination entre le modèle et la vue.
 */
public class JeuControlleur {

    private JeuMemoire modele;
    private JeuVue vue;

    private Timer jeuTimer;
    private int elapsedTime;


    /**
     * Constructeur pour JeuControlleur.
     *
     * @param modele Le modèle du jeu.
     * @param vue    La vue du jeu.
     */
    public JeuControlleur(JeuMemoire modele, JeuVue vue) {
        this.modele = modele;
        this.vue = vue;

        initController();
    }

    /**
     * Initialise le controlleur.
     */
    public void initController() {
        vue.getVueCartes().addMouseListener(new CarteMouseAdapter(this));
        initMenuListeners();
        elapsedTime = 0;
        vue.getTimerLabel().setText("Temps : " + 0 + " s");
        jeuTimer = new Timer(1000, e -> {
            elapsedTime++;
            vue.getTimerLabel().setText("Temps : " + elapsedTime + " s");
        });
        prepareVue();
    }

    /**
     * Retourne le modèle du jeu.
     *
     * @return Le modèle du jeu.
     */
    public JeuMemoire getModele() {
        return modele;
    }

    /**
     * Retourne la vue du jeu.
     *
     * @return La vue du jeu.
     */
    public JeuVue getVue() {
        return vue;
    }

    /**
     * Méthode pour recommencer le jeu.
     */
    public void rejouer() {
        modele.nouvellePartie();
        vue.nouvellePartie();

        resetJeuTimer();

        JLayeredPane layeredPane = vue.getLayeredPane();
        Component[] components = layeredPane.getComponentsInLayer(JLayeredPane.POPUP_LAYER);
        for (Component component : components) {
            if (component instanceof VictoryNotificationPanel) {
                layeredPane.remove(component);
            }
        }
        layeredPane.repaint();

        for (MouseListener ml : vue.getVueCartes().getMouseListeners()) {
            vue.getVueCartes().removeMouseListener(ml);
        }

        vue.getVueCartes().addMouseListener(new CarteMouseAdapter(this));
        prepareVue();
    }

    /**
     * Crée une liste d'icônes d'images pour les cartes du jeu.
     *
     * @return La liste d'icônes d'images pour les cartes.
     */
    public List<ImageIcon> createImageCartes() {
        List<ImageIcon> imageCartes = new ArrayList<>();
        for (int i = 0; i < modele.getCartes().size(); i++) {
            ImageIcon icon = new ImageIcon(JeuControlleur.class.getResource("/images/" + modele.getCartes().get(i).getValeur().getImgName()));
            final int SCALED_WIDTH = 150;
            final int SCALED_HEIGHT = 150;
            Image scaledImage = icon.getImage().getScaledInstance(SCALED_WIDTH, SCALED_HEIGHT, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageCartes.add(scaledIcon);
        }
        return imageCartes;
    }

    /**
     * Prépare la vue pour le jeu en ajoutant les éléments nécessaires.
     */
    private void prepareVue() {
        for (int i = 0; i < 20; i++) {
            vue.getModelVueCartes().addElement(JeuVue.COULEUR_VERSO);
        }
        vue.showVue();
    }


    public Timer getJeuTimer() {
        return jeuTimer;
    }


    private void resetJeuTimer() {
        elapsedTime = 0;
        vue.getTimerLabel().setText("Temps : " + 0 + " s");
        if (jeuTimer.isRunning()) {
            jeuTimer.stop();
        }
    }

    private void initMenuListeners() {
        vue.getJeuMenuBar().getQuitItem().addActionListener(e -> System.exit(0));
        vue.getJeuMenuBar().getResetItem().addActionListener(e -> rejouer());
        vue.getJeuMenuBar().getApropItem().addActionListener(e -> vue.aboutMessage());
        vue.getJeuMenuBar().getInstItem().addActionListener(e -> vue.instructionMessage());
    }

}
