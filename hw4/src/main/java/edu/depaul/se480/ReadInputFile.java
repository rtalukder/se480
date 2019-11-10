package edu.depaul.se480;

import com.sun.prism.paint.Stop;

import java.io.IOException;

/**
 * Class: SE480 - class to read in files
 * Author: Raquib Talukder
 **/

public class ReadInputFile {
    private String filename;
    StopwordsPipe stopwordsPipe;

    public ReadInputFile(String filename) throws IOException {
        this.filename = filename;
        stopwordsPipe = new StopwordsPipe(filename);
    }

    public String getFilename(){
        return filename;
    }
}
