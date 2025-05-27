package Ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login_form extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public Login_form() {
        this.setTitle("LOGIN FORM");
        this.setSize(350, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("이메일");
        JLabel passwordLabel = new JLabel("비밀번호");
        this.emailField = new JTextField();
        this.passwordField = new JPasswordField();

        this.loginButton = new JButton("로그인");
        this.cancelButton = new JButton("취소");

        // 이벤트
        this.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.equals("hong@google.com") && password.equals("1234")) {
                    System.out.println("로그인 되었습니다.");
                } else {
                    System.out.println("이메일과 비밀번호를 다시 입력하십시오.");
                }
            }
        });

        this.cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emailField.setText("");
                passwordField.setText("");
            }
        });

        this.add(emailLabel);
        this.add(this.emailField);
        this.add(passwordLabel);
        this.add(this.passwordField);
        this.add(this.loginButton);
        this.add(this.cancelButton);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login_form();
    }
}
