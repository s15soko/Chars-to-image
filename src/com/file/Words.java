package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Words {
    private int fileLines = 0;
    private int fileMaxLineWidth = 0;
    private String fileName = "words.txt";

    Map<Integer, String> fileContent;

    public Words()
    {
        try{
            File tmpDir = new File(fileName);

            if(!tmpDir.exists()){
                tmpDir.createNewFile();
            }
        }catch (IOException e){
            // error
        }
    }

    /**
     * Scan file, get the file content, number of lines and max width of row.
     * @throws FileNotFoundException
     */
    public void scanFile() {
        fileContent = new HashMap<Integer, String>();

        Scanner myScanner = null;
        try {
            myScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e){
            // error
        }

        int fileTxtMaxWidth = 0;
        int fileTxtLines = 0;
        while(myScanner.hasNextLine()){
            String str = myScanner.nextLine();
            fileContent.put(fileTxtLines, str);

            int counter = 0;
            for(int sk = 0; sk < str.length(); sk++){
                counter++;
            }

            if(counter > fileTxtMaxWidth){
                fileTxtMaxWidth = counter;
            }

            fileTxtLines++;
        }

        fileLines = fileTxtLines;
        fileMaxLineWidth = fileTxtMaxWidth;
    }

    /**
     * Get file content
     * @return Map This is a map with file content for each row separately
     */
    public Map<Integer, String> getFileContent() {
        return fileContent;
    }
}
