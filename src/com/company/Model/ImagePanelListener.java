package com.company.Model;

import com.company.Model.Selections.SquareSelection;
import com.company.View.ImagePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by lukasz on 31/10/2017.
 */
public class ImagePanelListener implements MouseListener {

    private ImagePanel imagePanel;
    private int startX, startY;

    public ImagePanelListener(ImagePanel panel){
        imagePanel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //imagePanel.selections.add(new SquareSelection(e.getX(), e.getY(), 10, 10));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int positionX, positionY, width, height;

        if(e.getX() > startX){
            positionX = startX;
            width = e.getX() - startX;
        } else{
            positionX = e.getX();
            width = startX - e.getX();
        }

        if(e.getY() > startY){
            positionY = startY;
            height = e.getY() - startY;
        } else{
            positionY = e.getY();
            height = startY - e.getY();
        }

        imagePanel.selections.add((new SquareSelection(positionX, positionY, width, height)));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
