package com.company.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lukasz on 31/10/2017.
 */
public class GUI {

    public JFrame frame;
    public ImagePanel imagePanel;
    public MenuPanel menuPanel;
    public SelectionListPanel selectionListPanel;

    public GUI(){
        frame = new JFrame("Program");
        imagePanel = new ImagePanel();
        menuPanel = new MenuPanel();
        selectionListPanel = new SelectionListPanel();
    }

    public void show(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1024, 512));
        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
        frame.getContentPane().add(menuPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(selectionListPanel), BorderLayout.EAST);

        frame.pack();

        frame.setVisible(true);
    }
}
