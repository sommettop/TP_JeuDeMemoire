package Modele;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Classe représentant le jeu de mémoire.
 */
public class JeuMemoire implements JeuCartes {

    private List<Carte> cartes = new ArrayList<>();
    private int indexDejaRetournee;

    /**
     * Constructeur par défaut pour la classe JeuMemoire.
     */
    public JeuMemoire() {
        initialiser();
    }

    /**
     * Méthode pour initialiser le jeu de mémoire.
     */
    @Override
    public void initialiser() {
        indexDejaRetournee = -1;
        for (ValeurDeCarte valeur : ValeurDeCarte.values()) {
            cartes.add(new Carte(valeur));
            cartes.add(new Carte(valeur));
        }
        Collections.shuffle(cartes);
    }

    /**
     * Méthode pour commencer une nouvelle partie.
     */
    @Override
    public void nouvellePartie() {
        cartes.clear();
        initialiser();
    }

    /**
     * Méthode pour retourner une carte dans le jeu de mémoire.
     *
     * @param index L'index de la carte à retourner.
     */
    @Override
    public void retournerCarte(int index) {
        if (indexDejaRetournee == -1) {
            indexDejaRetournee = index;
            cartes.get(index).setRetournee(true);
        } else if (cartes.get(indexDejaRetournee).equals(cartes.get(index))) {
            cartes.get(index).setRetournee(true);
            cartes.get(index).setTrouvee(true);
            cartes.get(indexDejaRetournee).setTrouvee(true);
            indexDejaRetournee = -1;
        } else {
            cartes.get(indexDejaRetournee).setRetournee(false);
            indexDejaRetournee = -1;
        }

    }


    /**
     * Méthode pour vérifier si le jeu est terminé.
     *
     * @return true si le jeu est terminé, sinon false.
     */
    @Override
    public boolean estTermine() {
        for (Carte carte : cartes) {
            if (!carte.isTrouvee())
                return false;
        }
        return true;
    }

    /**
     * Getter pour obtenir la liste des cartes.
     *
     * @return La liste des cartes.
     */
    public List<Carte> getCartes() {
        return cartes;
    }
}


