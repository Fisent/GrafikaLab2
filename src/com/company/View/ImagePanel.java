package com.company.View;

import com.company.Model.Selections.ISelection;
import com.company.Model.Selections.SelectionFactory;
import com.company.Model.Selections.SquareSelection;

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
    public ArrayList<ISelection> selections;

    public ImagePanel(){
        factory = new SelectionFactory();
        selections = new ArrayList<>();
        selections.add(new SquareSelection(0, 0, 100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if(image!=null)
            g2d.drawImage(image, 0, 0, null);

        for(ISelection sel : selections){
            sel.drawYourself(g2d);
            repaint();
        }
    }

    public void updateImage(BufferedImage img){
        image = img;
        this.repaint();
    }
}
