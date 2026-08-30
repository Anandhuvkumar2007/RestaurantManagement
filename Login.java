import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {

    JFrame frame;
    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;

    public Login() {

        frame = new JFrame("Admin Login");
        frame.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 30);

        userField = new JTextField();
        userField.setBounds(150, 50, 150, 30);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);

        loginButton.addActionListener(this);

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(frame, "Login successful!");
            frame.dispose();

        } else {

            JOptionPane.showMessageDialog(
                frame,
                "Invalid username or password"
            );
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}