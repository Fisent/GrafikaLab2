package com.company.Model.Selections;

import com.company.View.ImagePanel;

import java.awt.*;

/**
 * Created by lukasz on 31/10/2017.
 */
public abstract class ASelection {

    public ImagePanel imagePanel = null;

    public ASelection(ImagePanel panel){
        imagePanel = panel;
    }

    public abstract void drawYourself(Graphics2D g2d);

}
