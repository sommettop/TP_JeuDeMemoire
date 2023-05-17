package Controleur;

import Modele.Carte;
import Vue.JeuVue;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour gérer les événements de la souris liés aux cartes du jeu.
 */
public class CarteMouseAdapter extends MouseAdapter {

    private int times = 0;
    private boolean isPaused = false;
    private JeuControlleur controlleur;
    private List<Carte> cartes;
    private JList<Object> vueCartes;
    private DefaultListModel<Object> modelVueCartes;
    private List<ImageIcon> imageCartes;
    private List<Integer> listRetournee = new ArrayList<>();
    ;

    /**
     * Constructeur pour CarteMouseAdapter.
     *
     * @param controlleur Le controlleur du jeu.
     */
    public CarteMouseAdapter(JeuControlleur controlleur) {
        this.controlleur = controlleur;
        this.cartes = controlleur.getModele().getCartes();
        this.vueCartes = controlleur.getVue().getVueCartes();
        this.modelVueCartes = controlleur.getVue().getModelVueCartes();
        this.imageCartes = controlleur.createImageCartes();
    }

    /**
     * Gère l'événement du clic de souris sur les cartes.
     *
     * @param e L'événement de la souris.
     */
    @Override
    public void mousePressed(MouseEvent e) {

        if (isPaused)
            return;

        if (e.getClickCount() == 1) {
            int selectedIndex = vueCartes.locationToIndex(e.getPoint());

            if (listRetournee.contains(selectedIndex)) {
                e.consume();
            } else {
                modelVueCartes.set(selectedIndex, imageCartes.get(selectedIndex));
                times++;
                if (times % 2 == 0) {
                    isPaused = true;
                    Timer timer = new Timer(1000, e1 -> {
                        retournerCarte(selectedIndex);
                        isPaused = false;
                        if (controlleur.getModele().estTermine()) {
                            controlleur.getVue().showVictoryNotification(controlleur.getVue().getLayeredPane(), controlleur);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    retournerCarte(selectedIndex);
                }
            }
        }
    }

    /**
     * Méthode pour retourner les cartes et mettre à jour l'affichage.
     *
     * @param index L'index de la carte à retourner.
     */
    private void retournerCarte(int index) {
        controlleur.getModele().retournerCarte(index);
        listRetournee.clear();
        for (int i = 0; i < cartes.size(); i++) {
            if (cartes.get(i).isRetournee()) {
                modelVueCartes.set(i, imageCartes.get(i));
                listRetournee.add(i);
            } else {
                modelVueCartes.set(i, JeuVue.COULEUR_VERSO);
            }
        }
    }

}
