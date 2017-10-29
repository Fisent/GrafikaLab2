package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by lukasz on 28/10/2017.
 */
public class MyPanel extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("sunset.png"));
        }catch(IOException e){e.printStackTrace();}

        g2d.drawImage(image, 0, 0, null);


    }
}
