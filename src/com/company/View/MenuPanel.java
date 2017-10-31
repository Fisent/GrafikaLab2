package com.company.View;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Fisent on 29.10.2017.
 */
public class MenuPanel extends JPanel {

    public JButton saveButton;
    public JButton loadInformationButton;
    public JButton loadImageButton;
    public JButton closeImageButton;


    public MenuPanel(){
        saveButton = new JButton("ZAPISZ");
        loadInformationButton = new JButton("WCZYTAJ ZAZNACZENIA");
        loadImageButton = new JButton("WCZYTAJ OBRAZEK");
        closeImageButton = new JButton("ZAMKNIJ OBRAZEK");

        add(saveButton);
        add(loadInformationButton);
        add(loadImageButton);
        add(closeImageButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
