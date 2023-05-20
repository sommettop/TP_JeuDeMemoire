package Controleur;

import Modele.JeuMemoire;
import Vue.JeuVue;
import Vue.VictoryNotificationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour gérer la logique du jeu et la coordination entre le modèle et la vue.
 */
public class JeuControlleur {

    private JeuMemoire modele;
    private JeuVue vue;

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


    private void initMenuListeners() {
        vue.getJeuMenuBar().getQuitItem().addActionListener(e -> System.exit(0));
        vue.getJeuMenuBar().getResetItem().addActionListener(e -> rejouer());
        vue.getJeuMenuBar().getApropItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "My Application\n\nVersion 1.0\n\n© 2023 My Company";
                JOptionPane.showMessageDialog(vue, message, "About", JOptionPane.INFORMATION_MESSAGE);

            }
        });


        vue.getJeuMenuBar().getInstItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "C'est un jeu de mémoire où vous devez retourner les cartes.\n" +
                        "Au début du jeu, toutes les cartes sont face cachée.\n" +
                        "Vous devez retourner deux cartes à la fois.\n" +
                        "Si les deux cartes ont le même image, vous pouvez les conserver.\n" +
                        "Sinon, vous devez les retourner face cachée à nouveau.\n" +
                        "L'objectif du jeu est de retourner toutes les cartes en trouvant les paires correspondantes.\n" +
                        "Bonne chance !";
                JOptionPane.showMessageDialog(vue, message, "Instructions", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }

}
