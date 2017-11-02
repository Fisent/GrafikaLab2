package com.company.Model;

import com.company.Model.Selections.ASelection;
import com.company.Model.Selections.RectangleSelection;
import com.company.View.ImagePanel;
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
                System.out.println(selection.toSerializableString());
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
                System.out.println(s);
                String[] tab = s.split(",");
                char type = s.charAt(0);
                switch (type) {
                    case 'r':
                        loadedList.add(getRectangleSelection(tab, imagePanel));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return loadedList;
    }

    private static RectangleSelection getRectangleSelection(String[] line, ImagePanel imagePanel){
        int x, y, width, height;
        x = Integer.parseInt(line[1]);
        y = Integer.parseInt(line[2]);
        width = Integer.parseInt(line[3]);
        height = Integer.parseInt(line[4]);

        return new RectangleSelection(x, y, width, height, imagePanel);
    }
}
