import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JPanel contentPanel;
    private JTextArea textArea1;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JCheckBox adminCheckBox;
    private JButton createUserButton;
    private JProgressBar progressBar;
    private JTextPane progressText;
    private static JTextArea user_field;

        private Register register;
        private CreateUserButtonListener createUserButtonListener;
        private String registered;

        public Register() {
            register = new Register();

            setTitle("User Management");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(contentPanel);
            pack();

            // Set the frame location to the center of the screen
            setLocationRelativeTo(null);

            // Save button event listener
            createUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveChanges();
                }
            });

            // Set the frame visible
            setVisible(true);
        }
        public void createUserButtonListener(CreateUserButtonListener listener) {
            this.createUserButtonListener = listener;
        }
        private void saveChanges() {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            boolean isAdmin = adminCheckBox.isSelected();


            // Notify the listener with the book object
            if (createUserButtonListener != null) {
                createUserButtonListener.onSaveClicked(null);
            }

            // Reset fields
            usernameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            adminCheckBox.setSelected(false);
        }
    }
}
