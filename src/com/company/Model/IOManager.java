package com.company.Model;

import com.company.Model.Selections.*;
import com.company.View.ImagePanel;
import org.w3c.dom.css.Rect;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lukasz on 31/10/2017.
 */
public class IOManager {
    public static BufferedImage loadImage(String filename){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filename));
        }catch (IOException e) {e.printStackTrace();}
        return image;
    }

    public static boolean saveFile(ArrayList<ASelection> selections){
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
            for(ASelection selection : selections){
                writer.write(selection.toSerializableString() + "\n");
            }
            writer.close();
            return true;
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<ASelection> loadFile(ImagePanel imagePanel){
        ArrayList<ASelection> loadedList = new ArrayList<ASelection>();
        try {
            Scanner scanner = new Scanner(new File("save.txt"));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] tab = s.split(",");
                char type = s.charAt(0);
                switch (type) {
                    case 'r':
                        loadedList.add(getRectangleSelection(tab, imagePanel));
                        break;
                    case 'o':
                        loadedList.add(getOvalSelection(tab, imagePanel));
                        break;
                    case 'p':
                        loadedList.add(getPolygonSelection(tab, imagePanel));
                        break;
                    case 'b':
                        loadedList.add(getBezierSelection(tab, imagePanel));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return loadedList;
    }

    private static RectangleSelection getRectangleSelection(String[] line, ImagePanel imagePanel){
        int x, y, width, height;
        x = Integer.parseInt(line[2]);
        y = Integer.parseInt(line[3]);
        width = Integer.parseInt(line[4]);
        height = Integer.parseInt(line[5]);

        RectangleSelection selection = new RectangleSelection(x, y, width, height, imagePanel);
        selection.id = Integer.parseInt(line[1]);
        return selection;
    }

    private static OvalSelection getOvalSelection(String[] line, ImagePanel imagePanel){
        int x, y, width, height;
        x = Integer.parseInt(line[2]);
        y = Integer.parseInt(line[3]);
        width = Integer.parseInt(line[4]);
        height = Integer.parseInt(line[5]);

        OvalSelection selection = new OvalSelection(x, y, width, height, imagePanel);
        selection.id = Integer.parseInt(line[1]);
        return selection;
    }

    private static PolygonSelection getPolygonSelection(String[] line, ImagePanel imagePanel){
        PolygonSelection selection = new PolygonSelection(imagePanel);
        selection.id = Integer.parseInt(line[1]);
        for(int i = 2; i< line.length-3; i+=2){
            int x = Integer.parseInt(line[i]);
            int y = Integer.parseInt(line[i+1]);
            selection.addPoint(x, y);
        }
        selection.points.add(new Point(selection.points.get(0)));
        return selection;
    }

    private static BezierSelection getBezierSelection(String[] line, ImagePanel imagePanel){
        BezierSelection selection = new BezierSelection(imagePanel);
        selection.id = Integer.parseInt(line[1]);
        for(int i = 2; i< line.length-3; i+=2){
            int x = Integer.parseInt(line[i]);
            int y = Integer.parseInt(line[i+1]);
            selection.addPoint(x, y);
        }
        selection.points.add(new Point(selection.points.get(0)));
        return selection;
    }

}
