package Vue;

import javax.swing.*;

/**
 * Classe pour créer la barre de menus du jeu.
 */
public class JeuMenuBar extends JMenuBar {

    private JMenu jeuMenu;
    private JMenu aideMenu;

    private JMenuItem resetItem;
    private JMenuItem quitItem;
    private JMenuItem instItem;
    private JMenuItem apropItem;


    /**
     * Constructeur pour JeuMenuBar. Initialise tous les éléments de menu.
     */
    public JeuMenuBar() {
        jeuMenu = new JMenu("Jeu");
        jeuMenu.setMnemonic('J');
        aideMenu = new JMenu("Aide");
        aideMenu.setMnemonic('A');
        resetItem = new JMenuItem("Redémarrer");
        resetItem.setMnemonic('R');
        quitItem = new JMenuItem("Quitter");
        quitItem.setMnemonic('Q');
        instItem = new JMenuItem("Instructions");
        instItem.setMnemonic('I');
        apropItem = new JMenuItem("À propos");

        jeuMenu.add(resetItem);
        jeuMenu.add(quitItem);
        aideMenu.add(instItem);
        aideMenu.add(apropItem);

        this.add(jeuMenu);
        this.add(aideMenu);
    }

    /**
     * Getter pour l'élément de menu "Redémarrer".
     *
     * @return L'élément de menu "Redémarrer".
     */
    public JMenuItem getResetItem() {
        return resetItem;
    }

    /**
     * Getter pour l'élément de menu "Quitter".
     *
     * @return L'élément de menu "Quitter".
     */
    public JMenuItem getQuitItem() {
        return quitItem;
    }

    /**
     * Getter pour l'élément de menu "Instructions".
     *
     * @return L'élément de menu "Instructions".
     */
    public JMenuItem getInstItem() {
        return instItem;
    }

    /**
     * Getter pour l'élément de menu "À propos".
     *
     * @return L'élément de menu "À propos".
     */
    public JMenuItem getApropItem() {
        return apropItem;
    }
}
