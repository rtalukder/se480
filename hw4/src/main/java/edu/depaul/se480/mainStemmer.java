/**
 * Class: <class_number> - <description>
 * Author: Raquib Talukder
 **/

package edu.depaul.se480;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class mainStemmer {
    /** Test program for demonstrating the Stemmer.  It reads text from a
     * a list of files, stems each word, and writes the result to standard
     * output. Note that the word stemmed is expected to be in lower case:
     * forcing lower case must be done outside the Stemmer class.
     * Usage: Stemmer file-name file-name ...
     */
    public static void main(String[] args) {
        char[] w = new char[501];
        String userFilepath = System.getProperty("user.dir");
        String testfileFilepath = userFilepath + "/" + "stemmerTest.txt";
        PorterStemmerPipe s = new PorterStemmerPipe();
        try {
            FileInputStream in = new FileInputStream(testfileFilepath);

            try {
                while (true) {
                    int ch = in.read();
                    if (Character.isLetter((char) ch)) {
                        int j = 0;

                        while (true) {
                            ch = Character.toLowerCase((char) ch);
                            w[j] = (char) ch;
                            if (j < 500) j++;
                            ch = in.read();
                            if (!Character.isLetter((char) ch)) {
                                /* to test add(char ch) */
                                for (int c = 0; c < j; c++) s.add(w[c]);

                                /* or, to test add(char[] w, int j) */
                                /* s.add(w, j); */

                                s.stem(); {
                                    String u;

                                    /* and now, to test toString() : */
                                    u = s.toString();

                                    /* to test getResultBuffer(), getResultLength() : */
                                    /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */

                                    //System.out.print(u);
                                }
                                break;
                            }
                        }
                    }

                    if (ch < 0) break;
                    //System.out.print((char) ch);
                }
            }
            catch (IOException e) {
                System.out.println("error reading");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
}
