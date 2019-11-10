package edu.depaul.se480;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class: SE480 - Pipe to get rid of non-alphabetical characters
 * Author: Raquib Talukder
 * Sources Used: https://alvinalexander.com/blog/post/java/remove-non-alphanumeric-characters-java-string (1)
 *               https://www.baeldung.com/java-write-to-file (2)
 **/

public class NonAlphabeticalPipe {
    private ArrayList<String> noStopwordsArrayList;
    private ArrayList<String> cleanedNonAlphabeticalArrayList = new ArrayList<>();
    private PorterStemmerPipe porterStemmerPipe;

    public NonAlphabeticalPipe(ArrayList<String> noStopwordsArrayList) throws IOException {
        this.noStopwordsArrayList = noStopwordsArrayList;
        this.porterStemmerPipe = new PorterStemmerPipe();
        RemoveNonAlpabeticalPipe();
        String tempFile = ArrayListToFile();
        porterStemmerPipe.RootWordsPipe(tempFile);
    }

    // source (1) used
    public ArrayList<String> RemoveNonAlpabeticalPipe(){
        for (String words : noStopwordsArrayList){
            String cleanedWord = words.trim().replaceAll("[^a-zA-Z0-9]", "");
            if(!(cleanedWord.isEmpty())){
                cleanedNonAlphabeticalArrayList.add(cleanedWord);
            }
        }
        return cleanedNonAlphabeticalArrayList;
    }

    // source (2) used
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
