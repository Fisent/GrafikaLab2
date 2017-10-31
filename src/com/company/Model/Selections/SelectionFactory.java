package com.company.Model.Selections;

import com.company.View.ImagePanel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by lukasz on 31/10/2017.
 */
public class SelectionFactory {

    public Selections currentSelection = Selections.SQUARE;
    public ImagePanel imagePanel;

    public SelectionFactory(ImagePanel imagePanel){
        this.imagePanel = imagePanel;
    }

    public ASelection createSelection(int x, int y){
        switch (currentSelection){
            case SQUARE:
                return new SquareSelection(0, 0, 10, 10, imagePanel);
            case CIRCLE:
                throw new NotImplementedException();
            case RECTANGLE:
                throw new NotImplementedException();
        }
        return null;
    }
}
