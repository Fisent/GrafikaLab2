package com.company.Model.Selections;

import com.company.View.ImagePanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fisent on 01.11.2017.
 */
import com.company.Model.Point;

public class PolygonSelection extends ASelection {

    public static final int DELTA = 20;

    public ArrayList<Point> points;
    private ImagePanel imagePanel;

    public PolygonSelection(ImagePanel imagePanel){
        super(imagePanel);
        points = new ArrayList<>();
        this.imagePanel = imagePanel;
        done = false;
    }


    @Override
    public void setId() {
        System.out.println("set id " + done);
        if(done)
            super.setId();
    }

    @Override
    public void addPoint(int x, int y){

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
        String out = "p," + id;
        for(Point p : points)
            out += "," + p.x + "," + p.y;
        return out;
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


            for (Point p : points) {
                g2d.drawString("o", p.x, p.y);
            }
            g2d.drawPolyline(pointsX, pointsY, nOfPoints);
        }

        else {
            g2d.drawPolygon(pointsX, pointsY, nOfPoints);
        }

    }

    @Override
    public String toString(){
        return "Polygon" + id;
    }
}
