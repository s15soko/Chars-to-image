package com.mainclass;

import com.colors.Colors;
import com.file.Words;
import com.myimage.MyImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        createFile();
    }

    /**
     * Create an image file
     */
    public static void createFile() {
        MyImage myImage = new MyImage();
        BufferedImage img = new BufferedImage(myImage.getRequireImageWidth(), myImage.getRequireImageHeight(), BufferedImage.TYPE_INT_ARGB);
        File f = null;

        setPixels(img, myImage);

        try {
            f = new File(myImage.getFileName() + "." + myImage.getFileFormat());
            ImageIO.write(img, myImage.getFileFormat(), f);
            System.out.println("Image file has been created successfully.");
        } catch (IOException e){
            System.out.println("An error occurred during creating file, error: " + e);
        }
    }

    /**
     * Set pixels by txt file content.
     * @param img
     * @param myImage
     */
    public static void setPixels(BufferedImage img, MyImage myImage)
    {
        Colors colors = new Colors();
        Map<String, String> colorsMap = colors.getCharsColors();

        int requiredImageHeight = myImage.getRequireImageHeight();
        int requiredImageWidth = myImage.getRequireImageWidth();

        Words words = new Words();
        words.scanFile();
        Map<Integer, String> fileContent = words.getFileContent();

        int stringlineWidth = 0;
        String lineValue = null;
        String mycol = null;
        Color col = null;

        for (int h = 0; h < requiredImageHeight; h++)
        {
            lineValue = fileContent.get(h);
            stringlineWidth = 0;

            if(lineValue != null){
                stringlineWidth = lineValue.length();
            }

            for (int w = 0; w < requiredImageWidth; w++)
            {
                mycol = null;
                if(w < stringlineWidth){
                    mycol = colorsMap.get(Character.toString(lineValue.charAt(w)));
                    if(mycol == null){
                        mycol = colors.getDefaultCharColor();
                    }
                }
                else{
                    mycol = colors.getDefaultCharColor();
                }

                col = colors.createColor("#" + mycol);
                int rgb = colors.createRGBFromColor(col);

                img.setRGB(w, h, rgb);
            }
        }
    }
}
