package pl;

import javax.swing.*;
/*
public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(()->new Sumator());
    }
}
*/

import java.util.Scanner;

public class Main {

    public  static  void  main(String [] args) throws Exception {
        try {
            SwingUtilities.invokeLater(() -> new Calc());
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}

