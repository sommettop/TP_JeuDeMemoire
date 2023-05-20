package Vue;

import javax.swing.*;

public class MessageNotification extends JOptionPane {


    public void showMessage(JFrame frame, String title, String message) {

        showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
