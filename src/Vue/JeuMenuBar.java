package Vue;

import javax.swing.*;

public class JeuMenuBar extends JMenuBar {

    private JMenu jeuMenu;
    private JMenu aideMenu;

    private JMenuItem resetItem;
    private JMenuItem quitItem;
    private JMenuItem instItem;
    private JMenuItem apropItem;

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


    public JMenuItem getResetItem() {
        return resetItem;
    }

    public JMenuItem getQuitItem() {
        return quitItem;
    }

    public JMenuItem getInstItem() {
        return instItem;
    }

    public JMenuItem getApropItem() {
        return apropItem;
    }
}
