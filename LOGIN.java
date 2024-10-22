package LoginPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LOGIN {
    private Map<String, String> users;

    public LOGIN() {
        users = new HashMap<>();
        users.put("esther", "esther123");

        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setBackground(new Color(210, 210, 210));

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        formPanel.add(userLabel);
        formPanel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        formPanel.add(passwordLabel);
        formPanel.add(passwordText);

        JLabel regLabel = new JLabel("Registration Number:");
        JTextField regText = new JTextField();
        formPanel.add(regLabel);
        formPanel.add(regText);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(200, 200, 200));

        JButton loginButton = new JButton("LOGIN");
        JButton signUpButton = new JButton("SIGN UP");
        loginButton.setBackground(new Color(50, 150, 200));
        loginButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(50, 150, 50));
        signUpButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        JLabel successLabel = new JLabel("", SwingConstants.CENTER);
        successLabel.setForeground(Color.RED);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String regNumber = regText.getText();

                if (users.containsKey(username)) {
                    successLabel.setText("Username already exists. Please choose a different username.");
                } else {
                    users.put(username, password);
                    successLabel.setText("User signed up successfully.");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    successLabel.setText("Please enter both username and password.");
                } else if (users.containsKey(username) && users.get(username).equals(password)) {
                    JFrame newFrame = new JFrame("Welcome");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.setSize(300, 150);
                    newFrame.setLayout(new FlowLayout());

                    JLabel welcomeLabel = new JLabel("Welcome, " + username);
                    JLabel regNumberLabel = new JLabel("Reg Number: " + (username.equals("esther") ? "H230765A" : ""));
                    newFrame.add(welcomeLabel);
                    newFrame.add(regNumberLabel);

                    newFrame.setVisible(true);
                    frame.dispose();
                } else {
                    successLabel.setText("Invalid username or password, try again.");
                }
            }
        });

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(successLabel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LOGIN();
            }
        });
    }
}