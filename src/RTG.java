import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
class RTG{
    public String Text() {
        //Creating a linked list in an array
        List<String> TextList = new ArrayList<>();
        String RandomText = null;
        try {
            File TextFile = new File("gameDictionary.txt");
            Scanner TextReader = new Scanner(TextFile);
            while (TextReader.hasNextLine()) {
                String Textdata = TextReader.nextLine();
                TextList.add(Textdata);
            }
            //System.out.println(TextList);
            //Noe getting the random element in the array
            Random rand = new Random();
            int randomIndex = rand.nextInt(TextList.size());
            RandomText = TextList.get(randomIndex);
            //System.out.println(RandomText);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is missing please enter the file");
            e.printStackTrace();
        }
        return RandomText;
    }
}

