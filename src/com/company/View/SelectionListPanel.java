package com.company.View;

import com.company.Model.Listeners.DeleteSelectionButton;
import com.company.Model.Selections.ASelection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fisent on 29.10.2017.
 */
public class SelectionListPanel extends JPanel {

    private ArrayList<ASelection> selections;
    private ImagePanel imagePanel;
    private JLabel instructionLabel;

    public SelectionListPanel(ImagePanel imagePanel){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        instructionLabel = new JLabel("<html><font color='white'>Naciśnij, żeby usunąć</font></html>");
        this.imagePanel = imagePanel;
    }

    public void setList(ArrayList<ASelection> list){
        selections = list;
        updateList();
    }

    private void updateList(){
        repaint();
        revalidate();
        removeAll();
        add(instructionLabel);
        for(ASelection selection : selections){
            DeleteSelectionButton button = new DeleteSelectionButton(selection.toString(), selection, imagePanel, this);
            add(button);
            button.addActionListener(button);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
