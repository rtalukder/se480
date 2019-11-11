package edu.depaul.se480;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        try {
            System.out.println("#### Execution times for the US Declaration of Independence (times in ms ) ####"  + "\n");
            ReadInputFile USDeclaration = new ReadInputFile("usdeclar.txt");

            System.out.println();

            System.out.println("#### Execution times for Alice's Adventure in Wonderland (times in ms ) ####" + "\n");
            ReadInputFile Alice = new ReadInputFile("alice30.txt");

            System.out.println();

            System.out.println("#### Execution times for the King James Bible (times in ms ) ####" + "\n");
            ReadInputFile KJBible = new ReadInputFile("kjbible.txt");

        }
        catch (IOException exception){
            System.out.printf("IO Exception caught.");
        }

//        StopwordsPipe alice30Pipe = new StopwordsPipe(alice30.getFilename());
//        ArrayList<String> stoppedAlice = alice30Pipe.RemoveStopwords();
//        NonAlphabeticalPipe aliceNonPipe = new NonAlphabeticalPipe(stoppedAlice);
//        ArrayList<String> nonAlphaAlice = aliceNonPipe.RemoveNonAlpabeticalPipe();
//        DataSinkPipe aliceDataPipe = new DataSinkPipe(nonAlphaAlice);
//        System.out.println(aliceDataPipe.OrderTopTen());
//
//        System.out.println(aliceNonPipe.RemoveNonAlpabeticalPipe().toString());
//        System.out.println(aliceNonPipe.ArrayListToFile());
//
//        PorterStemmerPipe stemmerPipe = new PorterStemmerPipe();
//        System.out.println(stemmerPipe.RootWordsPipe("temp.txt"));
//        ArrayList<String> stemmerArrayList = stemmerPipe.RootWordsPipe("temp.txt");
//        DataSinkPipe aliceDataPipe = new DataSinkPipe(stemmerArrayList);
//        System.out.println(aliceDataPipe.OrderTopTen());

//        StopwordsPipe usdeclarPipe = new StopwordsPipe(usdeclar.getFilename());
//        ArrayList<String> stoppedUSDeclar = usdeclarPipe.RemoveStopwords();
//        NonAlphabeticalPipe usdeclarNonPipe = new NonAlphabeticalPipe(stoppedUSDeclar);
//        ArrayList<String> nonAlphaUS = usdeclarNonPipe.RemoveNonAlpabeticalPipe();
//        DataSinkPipe usDataPipe = new DataSinkPipe(nonAlphaUS);
//        System.out.println(usDataPipe.OrderTopTen());
//
//        StopwordsPipe kjbiblePipe = new StopwordsPipe(kjbible.getFilename());
//        ArrayList<String> stoppedKjBible = kjbiblePipe.RemoveStopwords();
//        NonAlphabeticalPipe kjbibleNonPipe = new NonAlphabeticalPipe(stoppedKjBible);
//        ArrayList<String> nonAlphaKJ = kjbibleNonPipe.RemoveNonAlpabeticalPipe();
//        DataSinkPipe kjDataPipe = new DataSinkPipe(nonAlphaKJ);
//        System.out.println(kjDataPipe.OrderTopTen());
    }
}
