package Modele;
/**
 * Interface représentant un jeu de cartes.
 */
public interface JeuCartes {
    /**
     * Méthode pour initialiser le jeu de cartes.
     */
    void initialiser();
    /**
     * Méthode pour commencer une nouvelle partie.
     */
    void nouvellePartie();
    /**
     * Méthode pour retourner une carte dans le jeu de cartes.
     *
     * @param index L'index de la carte à retourner.
     */
    void retournerCarte(int index);
    /**
     * Méthode pour vérifier si le jeu est terminé.
     *
     * @return true si le jeu est terminé, sinon false.
     */
    boolean estTermine();
    
}
