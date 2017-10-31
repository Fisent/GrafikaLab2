package com.company.View;

import com.company.Model.Selections.ASelection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fisent on 29.10.2017.
 */
public class SelectionListPanel extends JPanel {

    private ArrayList<ASelection> selections;

    public SelectionListPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setList(ArrayList<ASelection> list){
        selections = list;
        updateList();
    }

    private void updateList(){
        removeAll();
        for(ASelection selection : selections){
            JButton button = new JButton(selection.toString());
            add(button);
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
