package com.company.Model.Selections;

import com.company.Model.Selections.Selections;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by lukasz on 31/10/2017.
 */
public class SelectionFactory {

    public Selections currentSelection = Selections.SQUARE;

    public ISelection createSelection(int x, int y){
        switch (currentSelection){
            case SQUARE:
                return new SquareSelection(0, 0, 10, 10);
            case CIRCLE:
                throw new NotImplementedException();
            case RECTANGLE:
                throw new NotImplementedException();
        }
        return null;
    }
}
