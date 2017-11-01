package com.company.Model.Listeners;

import com.company.Main;
import com.company.Model.Selections.Selections;
import com.company.View.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Fisent on 01.11.2017.
 */
public class OvalSelectionButtonListener implements ActionListener {

    private ImagePanel imagePanel;

    public OvalSelectionButtonListener(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(MouseListener ml : imagePanel.getMouseListeners())
            imagePanel.removeMouseListener(ml);
        for(MouseMotionListener ml : imagePanel.getMouseMotionListeners())
            imagePanel.removeMouseMotionListener(ml);

        imagePanel.addMouseListener(Main.imagePanelListener);
        imagePanel.addMouseMotionListener(Main.imagePanelListener);

        imagePanel.factory.currentSelection = Selections.CIRCLE;
    }
}