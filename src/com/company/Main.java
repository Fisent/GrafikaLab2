package com.company;


import com.company.Model.CloseImageButtonListener;
import com.company.Model.ImagePanelListener;
import com.company.Model.LoadImageButtonListener;
import com.company.View.GUI;
import com.company.View.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.show();

        gui.menuPanel.loadImageButton.addActionListener(new LoadImageButtonListener(gui.imagePanel));
        gui.menuPanel.closeImageButton.addActionListener(new CloseImageButtonListener(gui.imagePanel));
        gui.imagePanel.addMouseListener(new ImagePanelListener(gui.imagePanel));
    }
}
