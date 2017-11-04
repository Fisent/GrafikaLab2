package com.company;


import com.company.Model.Listeners.*;
import com.company.View.GUI;
import com.company.View.ImagePanel;

public class Main {

    public static ImagePanelListener imagePanelListener = null;
    public static ImagePanelMultipleListener imagePanelMultipleListener;

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.show();

        imagePanelListener = new ImagePanelListener(gui.imagePanel, gui.selectionListPanel, gui.imagePanel.factory);
        imagePanelMultipleListener = new ImagePanelMultipleListener(gui.imagePanel, gui.selectionListPanel, gui.imagePanel.factory);

        gui.menuPanel.loadImageButton.addActionListener(new LoadImageButtonListener(gui.imagePanel));
        gui.menuPanel.closeImageButton.addActionListener(new CloseImageButtonListener(gui.imagePanel));
        gui.menuPanel.saveButton.addActionListener(new SaveButtonListener(gui.imagePanel));
        gui.menuPanel.loadInformationButton.addActionListener(new LoadButtonListener(gui.imagePanel));
        gui.menuPanel.circleSelectionButton.addActionListener(new OvalSelectionButtonListener(gui.imagePanel));
        gui.menuPanel.rectangleSelectionButton.addActionListener(new RectangleSelectionButtonListener(gui.imagePanel));
        gui.menuPanel.polygonSelectionButton.addActionListener(new PolygonSelectionButtonListener(gui.imagePanel));
        gui.menuPanel.bezierSelectionButton.addActionListener(new BezierSelectionButtonListener(gui.imagePanel));
        gui.imagePanel.addMouseListener(imagePanelListener);
        gui.imagePanel.addMouseMotionListener(imagePanelListener);
    }
}
