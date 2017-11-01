package com.company.Model.Selections;

import com.company.View.ImagePanel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by Fisent on 01.11.2017.
 */
public class OvalSelection extends ASelection {

    private int x, y, width, height;

    public OvalSelection(int x, int y, int width, int height, ImagePanel imagePanel){
        super(imagePanel);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        drawId(x, y, g2d);
        g2d.drawOval(x, y, width, height);
    }

    @Override
    public String toString(){
        return "Circle" + id + " " + "x: " + x + ", y: " + y + " width: " + width + " height: " + height;
    }

    @Override
    public void addPoint(int x, int y) {
        throw  new NotImplementedException();
    }
}
