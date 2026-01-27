import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Register register = new Register();
            register.setVisible(true);
            
            register.createUserButtonListener((User user) -> {
                register.saveChanges();
            });
        });
    }
}
