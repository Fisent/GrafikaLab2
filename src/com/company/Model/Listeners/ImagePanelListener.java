package com.company.Model.Listeners;

import com.company.Model.Selections.ASelection;
import com.company.Model.Selections.SelectionFactory;
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
    private SelectionFactory factory;

    public ImagePanelListener(ImagePanel imagePanel, SelectionListPanel selectionListPanel, SelectionFactory factory){
        this.imagePanel = imagePanel;
        this.selectionListPanel = selectionListPanel;
        this.factory = factory;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ASelection selection = factory.createSelection(startX, startY, e.getX(), e.getY());
        selection.setId();
        imagePanel.selections.add(selection);

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
        ASelection selection = factory.createSelection(startX, startY, e.getX(), e.getY());
        imagePanel.temporarySelection = selection;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
