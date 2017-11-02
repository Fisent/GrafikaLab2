package com.company.Model.Selections;

import com.company.View.ImagePanel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by lukasz on 31/10/2017.
 */
public class RectangleSelection extends ASelection {
    public int x, y;

    public int width, height;

    public RectangleSelection(int x, int y, int width, int height, ImagePanel imagePanel){
        super(imagePanel);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawYourself(Graphics2D g2d) {

        g2d.draw(new Rectangle2D.Double(x,y,width,height));
        drawId(x-10, y, g2d);

    }

    @Override
    public void addPoint(int x, int y) {
        throw  new NotImplementedException();
    }

    @Override
    public String toSerializableString() {
        return "r," + id + "," + x + "," + y + "," + width + "," + height;
    }

    @Override
    public String toString(){
        return "s" + id + " " + "x: " + x + ", y: " + y + " width: " + width + ", height: " + height;
    }
}
