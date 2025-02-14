package GUI;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(" Main Frame ");
        //set width and height
        frame.setSize(400 , 400);
        frame.setLayout(null);
        frame.setVisible(true);
        JLabel l1 = new JLabel("click the button");
        l1.setBounds(120,68,100,30);
        frame.add(l1);
        JButton B1 = new JButton("Click here");
        B1.setBounds(120,100,100,50);
        frame.add(B1);




    }
}
