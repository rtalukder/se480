package edu.depaul.se480;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class StopwordsPipe {
    private ArrayList<String> listOfStopwords;
    private ArrayList<String> itemizedWordsArrayList;
    private String fileName;

    public StopwordsPipe(String fileName){
        this.fileName = fileName;
        ReadStopwordsFile();
        ReadTestFile();
    }

    private void ReadStopwordsFile(){
        String userFilepath = System.getProperty("user.dir");
        String stopwordsFilepath = userFilepath + "/stopwords.txt";

        try {
            List<String> stopwords = Files.readAllLines(Paths.get(stopwordsFilepath));
            this.listOfStopwords = (ArrayList<String>) stopwords;
        }
        catch (IOException exception){
            System.out.println("IO Exception thrown while reading file.");
        }
    }

    private void ReadTestFile(){
        String userFilepath = System.getProperty("user.dir");
        String testfileFilepath = userFilepath + "/" + fileName;

        try {
            List<String> itemizedWordsList = Files.readAllLines(Paths.get(testfileFilepath));

            System.out.println(itemizedWordsList.toString());
            this.itemizedWordsArrayList = (ArrayList<String>) itemizedWordsList;
        }
        catch (IOException exception){
            System.out.println("IO Exception thrown while reading file.");
        }
    }

    public ArrayList<String> RemoveStopwords(){
        boolean removedStopwordsArrayListBool = itemizedWordsArrayList.removeAll(listOfStopwords);
        System.out.println(itemizedWordsArrayList.toString());
        if (removedStopwordsArrayListBool) return itemizedWordsArrayList;
        else return itemizedWordsArrayList;
    }
}
