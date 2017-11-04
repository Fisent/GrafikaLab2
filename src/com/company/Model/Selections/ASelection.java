package com.company.Model.Selections;

import com.company.View.ImagePanel;

import java.awt.*;

/**
 * Created by lukasz on 31/10/2017.
 */
public abstract class ASelection {

    public ImagePanel imagePanel = null;
    public static int counter;
    public int id = -1;
    public boolean done = true;

    public ASelection(ImagePanel panel){
        imagePanel = panel;
    }

    public void setId(){
        id = counter++;
    }

    protected void drawId(int x, int y, Graphics2D g2d){
        if(id != -1)
            g2d.drawString(id+"", x, y);
    }

    public abstract void drawYourself(Graphics2D g2d);

    public abstract void addPoint(int x, int y);

    public abstract String toSerializableString();
}
