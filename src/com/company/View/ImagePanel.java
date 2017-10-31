package com.company.View;

import com.company.Model.Selections.ASelection;
import com.company.Model.Selections.SelectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Fisent on 29.10.2017.
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;
    public SelectionFactory factory;
    public ArrayList<ASelection> selections;
    public ASelection temporarySelection;

    public ImagePanel(){
        factory = new SelectionFactory(this);
        selections = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if(image!=null)
            g2d.drawImage(image, 0, 0, null);

        if(temporarySelection != null)
            temporarySelection.drawYourself(g2d);

        for(ASelection sel : selections){
            sel.drawYourself(g2d);
        }
        repaint();
    }

    public void updateImage(BufferedImage img){
        image = img;
        this.repaint();
    }
}
