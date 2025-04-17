import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Register register = new Register();
                register.setVisible(true);

                register.createUserButtonListener(new CreateUserButtonListener() {
                    @Override
                    public void onSaveClicked(User user) {
                        System.out.println("Entered Book Details:");
                    }
                });
            }
        });
    }
}
