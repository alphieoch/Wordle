import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class RTG{
    public boolean Text(){
        //Creating a linked list in an array
        List<Integer> list = new ArrayList<>();
        try{
            File myObj = new File("gameDictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
        }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is missing");
            e.printStackTrace();
        }


        return false;
    }
}

