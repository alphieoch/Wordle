//Word check to check if the word is valid... Goes through the words but outputs the location of the word in memory. disable till fix.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordcheck {
    //variables
    private String Wordcheck;
    public Wordcheck (String A1) {
        Wordcheck = A1;
    }
    public String Wordchecker() throws FileNotFoundException {
        File file = new File("gameDictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            int LN = 0; //line number
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LN++;
                if(Wordcheck == line) {
                    System.out.println("Text was found on " +LN);
                    //word is valid
                    return ("A");
                }
                else {
                    //word is invalid
                    return ("B");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
    }
        String invalid = "invalid";
        return (invalid);
    }
}


