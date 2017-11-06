package com.company.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lukasz on 31/10/2017.
 */
public class GUI {

    public static JFrame frame;
    public ImagePanel imagePanel;
    public MenuPanel menuPanel;
    public SelectionListPanel selectionListPanel;

    public GUI(){
        frame = new JFrame("Program");
        imagePanel = new ImagePanel();
        menuPanel = new MenuPanel();
        selectionListPanel = new SelectionListPanel(imagePanel);
    }

    public void show(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1024, 512));
        frame.getContentPane().setLayout(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(1000, 1000));
        JScrollPane scrollPane = new JScrollPane(imagePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(menuPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(selectionListPanel), BorderLayout.EAST);

        frame.pack();

        frame.setVisible(true);
    }
}
