import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class RTG{
    public boolean Text(){
        //Creating a linked list in an array
        List<String> TextList = new ArrayList<>();
        try{
            File TextFile = new File("gameDictionary.txt");
            Scanner TextReader = new Scanner(TextFile);
            while (TextReader.hasNextLine()) {
                String Textdata = TextReader.nextLine();
                TextList.add(Textdata);
        }
            System.out.println(TextList);


    } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is missing please enter the file");
            e.printStackTrace();
        }
        return false;}
}

