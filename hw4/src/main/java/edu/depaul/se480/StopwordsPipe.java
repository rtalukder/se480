package edu.depaul.se480;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class: SE480 - Pipe to get rid of stopwords
 * Author: Raquib Talukder
 * Sources Used: https://www.baeldung.com/java-string-remove-stopwords (1)
 **/

public class StopwordsPipe {
    private ArrayList<String> stopwordsArrayList;
    private ArrayList<String> linesArrayList;
    private ArrayList<String> cleanedLinesArrayList = new ArrayList<>();
    private ArrayList<String> cleanedItemizedWordsArrayList = new ArrayList<>();
    private ArrayList<String> cleanedItemizedWordsArrayListForLoop = new ArrayList<>();
    private String fileName;
    private NonAlphabeticalPipe nextPipe;

    public StopwordsPipe(String fileName) throws IOException {
//        long startTime = System.currentTimeMillis();
//        this.fileName = fileName;
//        ReadStopwordsFile();
//        ReadTestFile();
//        CleanTestFile();
//        ItemizeLines();
//        ArrayList<String> removedArray = RemoveStopwords();
//        long endTime = System.currentTimeMillis();
//        System.out.println("StopwordsPipe Execution time: " + (endTime - startTime));
//        this.nextPipe = new NonAlphabeticalPipe(removedArray);

        long startTime = System.currentTimeMillis();
        this.fileName = fileName;
        ReadStopwordsFile();
        ReadTestFile();
        CleanTestFile();
        ItemizeLines();
        ArrayList<String> removedArray = RemoveStopwordsForLoop();
        long endTime = System.currentTimeMillis();
        System.out.println("StopwordsPipe Execution time (for loop): " + (endTime - startTime));
        this.nextPipe = new NonAlphabeticalPipe(removedArray);

    }

    // source (1) used
    private void ReadStopwordsFile(){
        String userFilepath = System.getProperty("user.dir");
        String stopwordsFilepath = userFilepath + "/stopwords.txt";

        try {
            List<String> stopwords = Files.readAllLines(Paths.get(stopwordsFilepath));
            this.stopwordsArrayList = (ArrayList<String>) stopwords;
        }
        catch (IOException exception){
            System.out.println("IO Exception thrown while reading file.");
        }
    }

    // source (1) used
    private void ReadTestFile(){
        String userFilepath = System.getProperty("user.dir");
        String testfileFilepath = userFilepath + "/" + fileName;

        try {
            List<String> itemizedWordsList = Files.readAllLines(Paths.get(testfileFilepath));
            this.linesArrayList = (ArrayList<String>) itemizedWordsList;
        }
        catch (IOException exception){
            System.out.println("IO Exception thrown while reading file.");
        }
    }

    private void CleanTestFile(){
        for (String lines : linesArrayList){
            String[] splitLines = lines.toLowerCase().trim().split("\\s*,\\s*");
            List toArrayList = Arrays.asList(splitLines);
            if(!(toArrayList.isEmpty())){
                cleanedLinesArrayList.addAll(toArrayList);
            }
        }
    }

    private void ItemizeLines(){
        for (String lines : cleanedLinesArrayList){
            String[] splitLines = lines.trim().split(" ");
            List toArrayList = Arrays.asList(splitLines);
            if(!(toArrayList.isEmpty())){
                cleanedItemizedWordsArrayList.addAll(toArrayList);
            }
        }
    }

    // source (1) used
    public ArrayList<String> RemoveStopwords(){
        boolean removedStopwordsArrayListBool = cleanedItemizedWordsArrayList.removeAll(stopwordsArrayList);
        if (removedStopwordsArrayListBool) return cleanedItemizedWordsArrayList;
        else return cleanedItemizedWordsArrayList;
    }

    // source (1) used
    public ArrayList<String> RemoveStopwordsForLoop(){
        for (String words : cleanedItemizedWordsArrayList) {
            if (!(stopwordsArrayList.contains(words))) {
                cleanedItemizedWordsArrayListForLoop.add(words);
            }
        }
        return cleanedItemizedWordsArrayListForLoop;
    }
}
