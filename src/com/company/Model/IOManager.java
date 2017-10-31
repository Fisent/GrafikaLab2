package com.company.Model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public static boolean saveFile(){
        throw new NotImplementedException();
    }
}
