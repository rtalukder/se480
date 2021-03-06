package edu.depaul.se480;

import java.io.IOException;

/**
 * Class: SE480 - class to read in files
 * Author: Raquib Talukder
 **/

public class ReadInputFile {
    private String filename;
    StopwordsPipe stopwordsPipe;

    public ReadInputFile(String filename) throws IOException {
        long startTime = System.currentTimeMillis();
        this.filename = filename;
        long endTime = System.currentTimeMillis();
        System.out.println("ReadInputFile Execution time: " + (endTime - startTime));
        stopwordsPipe = new StopwordsPipe(filename);
    }

    public String getFilename(){
        return filename;
    }
}
