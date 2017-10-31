package com.company.Model.Listeners;

import com.company.Model.IOManager;
import com.company.View.ImagePanel;
import com.company.View.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panel.updateImage(IOManager.loadImage("sunset.png"));

    }
}
