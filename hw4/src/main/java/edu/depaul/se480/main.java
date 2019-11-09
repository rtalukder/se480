package edu.depaul.se480;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException  {
        ReadInputFile alice30 = new ReadInputFile("alice30.txt");
        ReadInputFile kjbible = new ReadInputFile("kjbible.txt");
        ReadInputFile usdeclar = new ReadInputFile("usdeclar.txt");

        StopwordsPipe alice30Pipe = new StopwordsPipe(alice30.getFilename());
        ArrayList<String> stoppedAlice = alice30Pipe.RemoveStopwords();
        NonAlphabeticalPipe aliceNonPipe = new NonAlphabeticalPipe(stoppedAlice);
        ArrayList<String> nonAlphaAlice = aliceNonPipe.RemoveNonAlpabeticalPipe();
//        DataSinkPipe aliceDataPipe = new DataSinkPipe(nonAlphaAlice);
        //System.out.println(aliceDataPipe.OrderTopTen());

        System.out.println(aliceNonPipe.RemoveNonAlpabeticalPipe().toString());
        System.out.println(aliceNonPipe.ArrayListToFile());

        PorterStemmerPipe stemmerPipe = new PorterStemmerPipe();
        System.out.println(stemmerPipe.RootWordsPipe("temp.txt"));
        ArrayList<String> stemmerArrayList = stemmerPipe.RootWordsPipe("temp.txt");
        DataSinkPipe aliceDataPipe = new DataSinkPipe(stemmerArrayList);
        System.out.println(aliceDataPipe.OrderTopTen());

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
