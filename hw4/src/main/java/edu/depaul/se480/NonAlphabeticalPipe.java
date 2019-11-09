package edu.depaul.se480;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class: SE480 - Pipe to get rid of non-alphabetical characters
 * Author: Raquib Talukder
 **/

public class NonAlphabeticalPipe {
    private ArrayList<String> noStopwordsArrayList;
    private ArrayList<String> cleanedNonAlphabeticalArrayList = new ArrayList<>();

    public NonAlphabeticalPipe(ArrayList<String> noStopwordsArrayList){
        this.noStopwordsArrayList = noStopwordsArrayList;
    }

    public ArrayList<String> RemoveNonAlpabeticalPipe(){
        for (String words : noStopwordsArrayList){
            String cleanedWord = words.trim().replaceAll("[^a-zA-Z0-9]", "");
            if(!(cleanedWord.isEmpty())){
                cleanedNonAlphabeticalArrayList.add(cleanedWord);
            }
        }
        return cleanedNonAlphabeticalArrayList;
    }

    public String ArrayListToFile() throws IOException {
        String fileName = "temp.txt";

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.flush();
        for(String words : cleanedNonAlphabeticalArrayList){
            printWriter.println(words);
        }
        printWriter.close();
        return fileName;
    }

}
