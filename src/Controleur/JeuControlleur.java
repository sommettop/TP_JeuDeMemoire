package Controleur;

import Modele.JeuMemoire;
import Vue.JeuVue;

import javax.swing.*;
import java.awt.*;
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
     * @param vue La vue du jeu.
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
        initController();
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

}
