package Vue;

import javax.swing.*;
import java.awt.*;

/**
 * Classe personnalisée pour le rendu des cellules de la liste des cartes.
 */
public class CarteCellRenderer extends DefaultListCellRenderer {
    /**
     * Permet de personnaliser le rendu des cellules de la liste des cartes.
     *
     * @param list La liste des éléments à afficher.
     * @param value La valeur de l'élément de la liste à afficher.
     * @param index L'index de l'élément dans la liste.
     * @param isSelected Si l'élément est sélectionné.
     * @param cellHasFocus Si la cellule a le focus.
     * @return Le composant graphique de l'élément personnalisé.
     */
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
        label.setBorder(BorderFactory.createLineBorder(getBackground(), 3));

        if (value instanceof Color) {
            label.setBackground((Color) value);
            label.setOpaque(true);
            label.setIcon(null);
        } else if (value instanceof ImageIcon) {
            label.setIcon((ImageIcon) value);
            label.setOpaque(false);
        }
        label.setText("");
        return label;
    }

}
