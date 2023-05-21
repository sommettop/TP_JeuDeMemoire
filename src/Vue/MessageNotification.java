package Vue;

import javax.swing.*;

/**
 * Classe pour afficher des notifications de message dans le jeu.
 */
public class MessageNotification extends JOptionPane {

    /**
     * Affiche une notification avec un message spécifique.
     *
     * @param frame   La fenêtre dans laquelle le message sera affiché.
     * @param title   Le titre de la fenêtre de message.
     * @param message Le contenu du message à afficher.
     */
    public void showMessage(JFrame frame, String title, String message) {

        showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
