package com.company.Model.Selections;

import com.company.Model.Point;
import com.company.View.ImagePanel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lukasz on 31/10/2017.
 */
public class SelectionFactory {

    public Selections currentSelection = Selections.RECTANGLE;
    public ImagePanel imagePanel;

    public PolygonSelection polygonSelectionInProgress;

    public SelectionFactory(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }

    public ASelection createSelection(int startX, int startY, int finalX, int finalY){
        switch (currentSelection){
            case RECTANGLE:
                return createSquare(startX, startY, finalX, finalY);
            case CIRCLE:
                return createCircle(startX, startY, finalX, finalY);
        }
        return null;
    }

    private RectangleSelection createSquare(int startX, int startY, int finalX, int finalY){
        int positionX, positionY, width, height;

        if(finalX > startX){
            positionX = startX;
            width = finalX - startX;
        } else{
            positionX = finalX;
            width = startX - finalX;
        }

        if(finalY > startY){
            positionY = startY;
            height = finalY - startY;
        } else{
            positionY = finalY;
            height = startY -finalY;
        }

        return new RectangleSelection(positionX, positionY, width, height, imagePanel);
    }

    private OvalSelection createCircle(int startX, int startY, int finalX, int finalY) {
        int positionX, positionY, width, height;

        if (finalX > startX) {
            positionX = startX;
            width = finalX - startX;
        } else {
            positionX = finalX;
            width = startX - finalX;
        }

        if (finalY > startY) {
            positionY = startY;
            height = finalY - startY;
        } else {
            positionY = finalY;
            height = startY - finalY;
        }

        return new OvalSelection(positionX, positionY, width, height, imagePanel);
    }
}
