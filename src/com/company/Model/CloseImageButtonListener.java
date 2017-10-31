package com.company.Model;

import com.company.View.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lukasz on 31/10/2017.
 */
public class CloseImageButtonListener implements ActionListener {

    private ImagePanel imagePanel;

    public CloseImageButtonListener(ImagePanel panel){
        imagePanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imagePanel.updateImage(null);
    }
}
