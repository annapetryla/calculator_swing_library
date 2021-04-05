package pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sumator extends JFrame {

    Sumator() {

        JPanel panel = new JPanel();
        add(panel);

        JTextField jTextField = new JTextField ("");
        JTextField jTextField2 = new JTextField ("");
        jTextField.setPreferredSize ( new Dimension (100 , 20));
        jTextField2.setPreferredSize ( new Dimension (100 , 20));
        JLabel jLabel = new JLabel("+");
        JButton jButton = new JButton("wynik");

        panel.add(jTextField);
        panel.add(jLabel);
        panel.add(jTextField2);
        panel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int i = Integer.parseInt(jTextField.getText());
                    int j = Integer.parseInt(jTextField2.getText());
                    int sum = i + j;
                    jButton.setText(String.valueOf(sum));
                }
                catch (Exception exception) {
                    System.out.println("Nieprawdidłowa wartość na wejściu");
                }
            }
        });

        setVisible(true);
        setSize(new Dimension(600,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}
