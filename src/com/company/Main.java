package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setTitle("Hello graphics");

        MyPanel panel = new MyPanel();

        ramka.getContentPane().add(panel);
        ramka.setSize(300, 300);
        ramka.setVisible(true);
    }
}
