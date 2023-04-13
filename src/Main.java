import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        File file = new File("data/data.txt");
      File file2 = new File("outputData.xml");
        FileReader fileReader = new FileReader();


        ArrayList<String> txtLaptops = fileReader.readTxtFile(file);
        ArrayList<Laptop> laptops = new ArrayList<>();

        LaptopCreator laptopCreator = new LaptopCreator();
        laptops = laptopCreator.createComputerSet(txtLaptops);

        Printer printer = new Printer();
        printer.printTable(laptops);
        printer.printQuantity(laptops);

        Window window = new Window(laptops);
        window.welcomeScreen(laptops);


        for (Laptop l: fileReader.readXmlFile(file2)
             ) {
            System.out.println(l.toString());
        }

    }


}