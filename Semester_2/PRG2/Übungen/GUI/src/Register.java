import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Register extends JFrame {
    private JPanel contentPanel;
    private JTextArea Users;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JCheckBox adminCheckBox;
    private JButton createUserButton;
    private JProgressBar progressBar;
    private JLabel progressText;
    private JLabel image;
    private static JTextArea user_field;

        private Register register;
        private CreateUserButtonListener createUserButtonListener;
        private String registered;
        private List<String> names = new ArrayList<>();
        private List<String> emails = new ArrayList<>();

        public Register() {

            setTitle("User Management");
            progressText.setText("0 / 19");
            try {
                BufferedImage myPicture = ImageIO.read(new File("management.png"));
                this.image.setIcon(new ImageIcon(myPicture));
            } catch (IOException e) {

            }
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

            setVisible(true);
        }

        public void createUserButtonListener(CreateUserButtonListener listener) {
            this.createUserButtonListener = listener;
        }

        public void saveChanges() {
            String text = Users.getText();
            int order = text.split("\n", -1).length;
            if(order == 20) {
                try {
                    BufferedImage memoryPic = ImageIO.read(new File("alert.png"));
                    JOptionPane.showMessageDialog(
                            contentPanel,
                            "Memory limit exceeded - cannot add another user",
                            "Error Memory Limit",
                            JOptionPane.ERROR_MESSAGE, new ImageIcon(memoryPic));
                } catch (IOException e) {}
                return;
            } else if (this.names.contains(usernameField.getText())) {
                try {
                    BufferedImage memoryPic = ImageIO.read(new File("duplicate.png"));
                    JOptionPane.showMessageDialog(
                            contentPanel,
                            "User already exists!",
                            "Duplicate Warning",
                            JOptionPane.WARNING_MESSAGE, new ImageIcon(memoryPic));
                } catch (IOException e) {}
                return;
            } else if (this.emails.contains(emailField.getText())) {
                try {
                    BufferedImage memoryPic = ImageIO.read(new File("email.png"));
                    JOptionPane.showMessageDialog(
                            contentPanel,
                            "E-Mail address already exists!",
                            "Duplicate Warning",
                            JOptionPane.WARNING_MESSAGE, new ImageIcon(memoryPic));
                } catch (IOException e) {}
                return;
            }
            String username = usernameField.getText();
            String email = emailField.getText();
            boolean isAdmin = adminCheckBox.isSelected();



            this.progressText.setText(order + " / 19");
            this.progressBar.setValue((order * 5) + 5);
            Users.setText(text += String.format("%d. %s(%s, %s)%n", order, username, (isAdmin) ? "Admin" : "", email));

            this.names.add(username);
            this.emails.add(email);
            // Reset fields
            usernameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            adminCheckBox.setSelected(false);
        }
    }
