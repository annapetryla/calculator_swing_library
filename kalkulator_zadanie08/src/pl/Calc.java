package pl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calc extends JFrame implements Dzialaj {

    private static HashMap<String, BinaryOperator<Integer>> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(String.valueOf('+'), (a, b) -> a + b);
        hashMap.put(String.valueOf('-'), (a, b) -> a - b);
        hashMap.put(String.valueOf('/'), (a, b) -> a / b);
        hashMap.put(String.valueOf('*'), (a, b) -> a * b);
        hashMap.put(String.valueOf('^'), (a, b) -> Math.toIntExact((long) Math.pow(a, b)));
    }

    @Override
    public Integer doCalc(int a, String op, int b) throws Exception {
        return hashMap.get(op).apply(a, b);
    }

    Calc() {

        JPanel panel = new JPanel();
        add(panel);
        JTextField jTextField = new JTextField("");
        JTextField jTextField2 = new JTextField("");
        JTextField jTextField3 = new JTextField("");
        jTextField.setPreferredSize(new Dimension(100, 20));
        jTextField2.setPreferredSize(new Dimension(100, 20));
        jTextField3.setPreferredSize(new Dimension(100, 20));

        JButton jButton2 = new JButton("+");
        JButton jButton3 = new JButton("-");
        JButton jButton4 = new JButton("*");
        JButton jButton5 = new JButton("/");
        JButton jButton6 = new JButton("^");
        JLabel label = new JLabel("=");

        GridLayout gridLayout = new GridLayout(5, 1);
        panel.add(jTextField);
        panel.add(jButton2, gridLayout);
        panel.add(jButton3, gridLayout);
        panel.add(jButton4, gridLayout);
        panel.add(jButton5, gridLayout);
        panel.add(jButton6, gridLayout);
        panel.add(jTextField2);
        panel.add(label);
        panel.add(jTextField3);

            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(jTextField.getText());
                    int b = Integer.parseInt(jTextField2.getText());
                    try {
                        jTextField3.setText(String.valueOf(doCalc(a, "+", b)));
                    } catch (NumberFormatException exception) {
                        System.out.println("Podaj drugą wartość");
                        jTextField3.setText("ERROR");
                    } catch (Exception exception) {
                        System.out.println("ERROR");
                    }
                }
            });
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int a = Integer.parseInt(jTextField.getText());
                    int b = Integer.parseInt(jTextField2.getText());
                    try {
                        jTextField3.setText(String.valueOf(doCalc(a, "-", b)));
                    } catch (NumberFormatException exception) {
                        System.out.println("Podaj drugą wartość");
                        jTextField3.setText("ERROR");
                    } catch (Exception exception) {
                        System.out.println("ERROR");
                    }
                }
            });
            jButton4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(jTextField.getText());
                    int b = Integer.parseInt(jTextField2.getText());
                    try {
                        jTextField3.setText(String.valueOf(doCalc(a, "*", b)));
                    } catch (NumberFormatException exception) {
                        System.out.println("Podaj drugą wartość");
                        jTextField3.setText("ERROR");
                    } catch (Exception exception) {
                        System.out.println("ERROR");
                    }
                }
            });
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(jTextField.getText());
                    int b = Integer.parseInt(jTextField2.getText());
                    try {
                        jTextField3.setText(String.valueOf(doCalc(a, "/", b)));
                    } catch (ArithmeticException exception) {
                        jTextField3.setText("ERROR");
                        System.out.println("Probujesz dzielić przez zero");
                    } catch (NumberFormatException exception) {
                        System.out.println("Podaj drugą wartość");
                        jTextField3.setText("ERROR");
                    } catch (Exception exception) {
                        System.out.println("ERROR");
                    }
                }
            });
            jButton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(jTextField.getText());
                    int b = Integer.parseInt(jTextField2.getText());
                    try {
                        jTextField3.setText(String.valueOf(doCalc(a, "^", b)));
                    } catch (NumberFormatException exception) {
                        System.out.println("Podaj drugą wartość");
                        jTextField3.setText("ERROR");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });

            setVisible(true);
            setSize(new Dimension(600, 300));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }

    }
