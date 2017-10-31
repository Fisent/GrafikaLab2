package com.company.Model.Selections;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by lukasz on 31/10/2017.
 */
public class SquareSelection implements ISelection {
    public int x, y;

    public int width, height;

    public SquareSelection(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        g2d.draw(new Rectangle2D.Double(x,y,width,height));

    }
}
