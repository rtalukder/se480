package edu.depaul.se480;

public class main {
    public static void main(String[] args) {
        ReadInputFile alice30 = new ReadInputFile("alice30.txt");
        ReadInputFile kjbible = new ReadInputFile("kjbible.txt");
        ReadInputFile usdeclar = new ReadInputFile("usdeclar.txt");

        StopwordsPipe alice30Pipe = new StopwordsPipe(alice30.getFilename());
        alice30Pipe.RemoveStopwords();

//        StopwordsPipe kjbiblePipe = new StopwordsPipe(kjbible.getFilename());
//        kjbiblePipe.RemoveStopwords();
//
//        StopwordsPipe usdeclarPipe = new StopwordsPipe(usdeclar.getFilename());
//        usdeclarPipe.RemoveStopwords();
    }
}
