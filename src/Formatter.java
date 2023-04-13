import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Formatter {

    public File formatOutputAsInput(File file)
    {
      File fortmattedFile = new File("formatted.txt");
      try{
          fortmattedFile.createNewFile();
          PrintWriter pw = new PrintWriter("formatted.txt");
          pw.close();
      }
        catch(Exception e){
            System.out.println("formatted tile creation problem");
        }

        String data = null;
        StringBuilder strb = new StringBuilder();
        int counter = 0;
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                data = data.replaceAll("\\t\\t", ";");
                if(counter!=0)
                strb.append(data);
                strb.append("\n");
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Files.write(Paths.get("formatted.txt"), strb.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("formatting error");
        }
        return fortmattedFile;
    }

}
