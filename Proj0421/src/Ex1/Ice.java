package Ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ice extends JFrame {
    // 클래스 선언
    private JLabel label;
    private JButton yesButton;
    private JButton noButton;

    public Ice() {
        this.setTitle("판넬예제");
        this.setSize(350, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.label = new JLabel("아이스크림을 좋아하나요??");
        this.yesButton = new JButton("Yes");
        this.noButton = new JButton("No");

        // 이벤트
        this.yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("예, 아이스크림을 좋아합니다.");
            }
        });

        this.noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("아니오, 아이스크림을 좋아하지 않습니다.");
            }
        });

        this.add(this.label);
        this.add(this.yesButton);
        this.add(this.noButton);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ice();
    }
}
