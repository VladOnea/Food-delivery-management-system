package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textFieldUsername;
    JButton btnRegister;
    JButton btnLogin;

    /**
     * Create the frame.
     */
    public LoginGUI() {
        setTitle("Food delivery management system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBounds(184, 70, 121, 19);
        contentPane.add(passwordField);

        JLabel lblUsename = new JLabel("username");
        lblUsename.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblUsename.setBounds(105, 37, 59, 13);
        contentPane.add(lblUsename);

        JLabel lblPassword = new JLabel("password");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblPassword.setBounds(105, 72, 59, 13);
        contentPane.add(lblPassword);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnLogin.setBounds(105, 110, 200, 21);
        contentPane.add(btnLogin);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(184, 35, 121, 19);
        contentPane.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnRegister.setBounds(105, 141, 200, 21);
        contentPane.add(btnRegister);

        this.setVisible(true);

    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public String getUsername() {
        return textFieldUsername.getText();
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }
}
