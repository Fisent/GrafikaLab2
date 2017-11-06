package com.company.Model.Listeners;

import com.company.Model.IOManager;
import com.company.View.GUI;
import com.company.View.ImagePanel;
import com.company.View.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by lukasz on 31/10/2017.
 */
public class LoadImageButtonListener implements ActionListener {

    private ImagePanel panel;

    public LoadImageButtonListener(ImagePanel imagePanel){
        panel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage img = IOManager.loadImage();
        panel.updateImage(img);
        panel.selections.clear();
        GUI.frame.pack();
    }
}
