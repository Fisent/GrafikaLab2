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
public class BezierSelectionButtonListener implements ActionListener {

    private ImagePanel imagePanel;

    public BezierSelectionButtonListener(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(MouseListener ml : imagePanel.getMouseListeners())
            imagePanel.removeMouseListener(ml);
        for(MouseMotionListener ml : imagePanel.getMouseMotionListeners())
            imagePanel.removeMouseMotionListener(ml);

        imagePanel.addMouseListener(Main.imagePanelMultipleListener);

        imagePanel.factory.currentSelection = Selections.BEIZIER;
    }
}
