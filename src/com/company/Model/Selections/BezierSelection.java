package com.company.Model.Selections;

import com.company.Model.*;
import com.company.Model.Point;
import com.company.View.ImagePanel;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 * Created by Fisent on 04.11.2017.
 */
public class BezierSelection extends ASelection {

    public static final int DELTA = 20;

    public ArrayList<Point> points;


    public BezierSelection(ImagePanel imagePanel){
        super(imagePanel);
        points = new ArrayList<>();
        done = false;
    }

    @Override
    public void setId() {
        if(done)
            super.setId();
    }


    @Override
    public void drawYourself(Graphics2D g2d) {
        drawId(points.get(0).x, points.get(0).y, g2d);

        int nOfPoints = points.size();
        int[] pointsX = new int[nOfPoints];
        int[] pointsY = new int[nOfPoints];

        for(int i = 0; i< nOfPoints; i++){
            Point p = points.get(i);
            pointsX[i] = p.x;
            pointsY[i] = p.y;
        }

        if(!done) {
            g2d.drawPolyline(pointsX, pointsY, nOfPoints);
        }

        else {
            drawBezier(g2d);
        }
    }

    @Override
    public void addPoint(int x, int y) {
        Point newPoint = new Point(x, y);
        if(!points.isEmpty()) {

            int distance = points.get(0).distance(newPoint);
            done = distance <= DELTA;
            if(done){
                points.add(new Point(points.get(0)));
            }
            else points.add(newPoint);
        }
        else points.add(newPoint);
    }

    @Override
    public String toSerializableString() {
        String out = "b," + id;
        for(Point p : points)
            out += "," + p.x + "," + p.y;
        return out;
    }

    private void drawBezier(Graphics2D g2d){
        for(int i = 0; i < points.size() - 3; i += 3){
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            Point p3 = points.get(i + 2);
            Point p4 = points.get(i + 3);

            GeneralPath gp = new GeneralPath();
            gp.moveTo(p1.x, p1.y);
            gp.curveTo(p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);

            g2d.draw(gp);
        }
    }

    @Override
    public String toString(){
        return "Bezier #" + id;
    }
}
