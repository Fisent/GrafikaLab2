package com.company.Model.Listeners;

import com.company.Model.Selections.SquareSelection;
import com.company.View.GUI;
import com.company.View.ImagePanel;
import com.company.View.SelectionListPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by lukasz on 31/10/2017.
 */
public class ImagePanelListener implements MouseListener, MouseMotionListener {

    private ImagePanel imagePanel;
    private SelectionListPanel selectionListPanel;
    private int startX, startY;

    public ImagePanelListener(ImagePanel imagePanel, SelectionListPanel selectionListPanel){
        this.imagePanel = imagePanel;
        this.selectionListPanel = selectionListPanel;
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

        imagePanel.selections.add((new SquareSelection(positionX, positionY, width, height, imagePanel)));

        imagePanel.temporarySelection = null;
        selectionListPanel.setList(imagePanel.selections);

        GUI.frame.pack();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
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

        imagePanel.temporarySelection = new SquareSelection(positionX, positionY, width, height, imagePanel);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
