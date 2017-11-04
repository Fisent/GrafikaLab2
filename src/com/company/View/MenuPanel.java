package com.company.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by Fisent on 29.10.2017.
 */
public class MenuPanel extends JPanel {

    public JButton saveButton;
    public JButton loadInformationButton;
    public JButton loadImageButton;
    public JButton closeImageButton;

    //selection types button
    public JButton rectangleSelectionButton;
    public JButton circleSelectionButton;
    public JButton polygonSelectionButton;
    public JButton bezierSelectionButton;


    public MenuPanel(){
        saveButton = new JButton("ZAPISZ");
        loadInformationButton = new JButton("WCZYTAJ ZAZNACZENIA");
        loadImageButton = new JButton("WCZYTAJ OBRAZEK");
        closeImageButton = new JButton("ZAMKNIJ OBRAZEK");

        rectangleSelectionButton = new JButton("Prostokąt");
        circleSelectionButton = new JButton("Owal");
        polygonSelectionButton = new JButton("Wielokąt");
        bezierSelectionButton = new JButton("Bezier");


        add(saveButton);
        add(loadInformationButton);
        add(loadImageButton);
        add(closeImageButton);

        add(rectangleSelectionButton);
        add(circleSelectionButton);
        add(polygonSelectionButton);
        add(bezierSelectionButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }




}
