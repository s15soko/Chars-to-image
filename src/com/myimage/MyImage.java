package com.myimage;

public class MyImage {
    public int requireImageWidth = 512;
    public int requireImageHeight = 512;
    public String fileName = "Photo";
    public String fileFormat = "png";

    public int getRequireImageWidth() {
        return requireImageWidth;
    }

    public int getRequireImageHeight() {
        return requireImageHeight;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
