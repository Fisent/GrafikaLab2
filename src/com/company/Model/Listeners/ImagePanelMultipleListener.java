package com.company.Model.Listeners;

import com.company.Model.Point;
import com.company.Model.Selections.ASelection;
import com.company.Model.Selections.PolygonSelection;
import com.company.Model.Selections.SelectionFactory;
import com.company.View.GUI;
import com.company.View.ImagePanel;
import com.company.View.SelectionListPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Fisent on 01.11.2017.
 */
public class ImagePanelMultipleListener implements MouseListener {

    private ImagePanel imagePanel;
    private SelectionListPanel selectionListPanel;
    private SelectionFactory factory;

    private ASelection selectionInProgress;


    public ImagePanelMultipleListener(ImagePanel imagePanel, SelectionListPanel selectionListPanel, SelectionFactory factory){
        this.imagePanel = imagePanel;
        this.selectionListPanel = selectionListPanel;
        this.factory = factory;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(selectionInProgress == null)
            selectionInProgress = new PolygonSelection(imagePanel);

        selectionInProgress.addPoint(e.getX(), e.getY());

        if(selectionInProgress.done){
            selectionInProgress.setId();
            imagePanel.selections.add(selectionInProgress);
            selectionInProgress = null;
            imagePanel.temporarySelection = selectionInProgress;
        } else
            imagePanel.temporarySelection = selectionInProgress;

        selectionListPanel.setList(imagePanel.selections);
        GUI.frame.pack();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
