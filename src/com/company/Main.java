package com.company;


import com.company.Model.Listeners.CloseImageButtonListener;
import com.company.Model.Listeners.ImagePanelListener;
import com.company.Model.Listeners.LoadImageButtonListener;
import com.company.View.GUI;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.show();

        gui.menuPanel.loadImageButton.addActionListener(new LoadImageButtonListener(gui.imagePanel));
        gui.menuPanel.closeImageButton.addActionListener(new CloseImageButtonListener(gui.imagePanel));
        ImagePanelListener imagePanelListener = new ImagePanelListener(gui.imagePanel, gui.selectionListPanel);
        gui.imagePanel.addMouseListener(imagePanelListener);
        gui.imagePanel.addMouseMotionListener(imagePanelListener);
    }
}
