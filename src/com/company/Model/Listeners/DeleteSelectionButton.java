package com.company.Model.Listeners;

import com.company.Model.Selections.ASelection;
import com.company.View.GUI;
import com.company.View.ImagePanel;
import com.company.View.SelectionListPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fisent on 31.10.2017.
 */
public class DeleteSelectionButton extends JButton implements ActionListener{
    public ASelection selection;
    private ImagePanel imagePanel;
    private SelectionListPanel selectionListPanel;

    public DeleteSelectionButton(String s, ASelection selection, ImagePanel imagePanel, SelectionListPanel selectionListPanel){
        super(s);
        this.selection = selection;
        this.imagePanel = imagePanel;
        this.selectionListPanel = selectionListPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imagePanel.selections.remove(selection);
        selectionListPanel.setList(imagePanel.selections);
    }
}
