package Modele;

/**
 * Classe représentant une carte du jeu.
 */
public class Carte {

    private ValeurDeCarte valeur;
    private boolean retournee;
    private boolean trouvee;
    /**
     * Constructeur par défaut de la classe Carte.
     */
    public Carte() {
    }


    /**
     * Constructeur avec paramètre pour la classe Carte.
     *
     * @param valeur La valeur de la carte.
     */
    public Carte(ValeurDeCarte valeur) {
        this.valeur = valeur;
        retournee = false;
        trouvee = false;
    }
    /**
     * Méthode permettant de comparer si deux cartes ont la même valeur.
     *
     * @param carte La carte à comparer.
     * @return true si les cartes ont la même valeur, sinon false.
     */
    public boolean equals(Carte carte) {
        return this.valeur == carte.valeur;
    }


    /**
     * Getter pour obtenir la valeur de la carte.
     *
     * @return La valeur de la carte.
     */
    public ValeurDeCarte getValeur() {
        return valeur;
    }


    /**
     * Setter pour modifier la valeur de la carte.
     *
     * @param valeur La nouvelle valeur de la carte.
     */
    public void setValeur(ValeurDeCarte valeur) {
        this.valeur = valeur;
    }

    /**
     * Méthode pour vérifier si la carte est retournée.
     *
     * @return true si la carte est retournée, sinon false.
     */
    public boolean isRetournee() {
        return retournee;
    }



    /**
     * Méthode pour modifier l'état de la carte (retournée ou non).
     *
     * @param retournee L'état de la carte (true si retournée, sinon false).
     */
    public void setRetournee(boolean retournee) {
        this.retournee = retournee;
    }


    /**
     * Méthode pour vérifier si la carte a été trouvée.
     *
     * @return true si la carte a été trouvée, sinon false.
     */
    public boolean isTrouvee() {
        return trouvee;
    }

    /**
     * Méthode pour modifier l'état de la carte (trouvée ou non).
     *
     * @param trouvee L'état de la carte (true si trouvée, sinon false).
     */
    public void setTrouvee(boolean trouvee) {
        this.trouvee = trouvee;
    }


}
