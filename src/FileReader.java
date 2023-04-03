import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<String> readFile(File file){
        String data = null;
        ArrayList <String> laptopsFromTxt = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        try {
            Scanner myReader = new Scanner(file);
            LaptopCreator creator = new LaptopCreator();
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                laptopsFromTxt.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return laptopsFromTxt;
    }








}
