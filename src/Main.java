import Controleur.JeuControlleur;
import Modele.JeuMemoire;
import Vue.JeuVue;

/**
 * La classe Main est le point d'entrée du programme. Elle crée une nouvelle instance
 * de JeuControlleur en passant les objets JeuMemoire et JeuVue, puis initialise le jeu.
 */
public class Main {

    public static void main(String[] args) {

        JeuControlleur Jeu = new JeuControlleur(new JeuMemoire(), new JeuVue());
    }
}
