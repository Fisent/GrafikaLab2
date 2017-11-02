package com.company.Model.Listeners;

import com.company.Model.IOManager;
import com.company.View.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lukasz on 02/11/2017.
 */
public class SaveButtonListener implements ActionListener {

    private ImagePanel imagePanel;

    public SaveButtonListener(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IOManager.saveFile(imagePanel.selections);
    }
}
