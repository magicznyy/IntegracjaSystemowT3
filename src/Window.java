import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import static java.awt.Component.LEFT_ALIGNMENT;

public class Window {

    public static ArrayList<Laptop> laptops;

    public Window(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }

    public static void welcomeScreen(ArrayList <Laptop> laptops) {
        JFrame frame = new JFrame("Welcome screen");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Wybierz opcje:");
        JButton button = new JButton();
        JButton button2 = new JButton();
        button.setText("Importuj dane z pliku txt");


        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                printTable(laptops);
            }
        });

        button2.setText("Importuj dane z pliku xml");

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                printTable(laptops);
            }
        });

        panel.add(label);
        panel.add(button);
        panel.add(button2);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void printTable(ArrayList<Laptop> laptops) {

            JFrame f;
            f=new JFrame();
        f.setLayout(new GridLayout(2, 1));


            JPanel panel1 = new JPanel();
            String data [] [] = new String[laptops.size()][15];
            int counter =0;
            for (Laptop l:laptops
                 ) {
                for(int i=0;i<15;i++)
                        data[counter][i] = l.getLaptopTxt()[i];
                counter++;

            }

            String column[]={"Marka","Przekątna","Rozdzielczość","Typ matrycy", "Czy dotykowa", "Procesor", "Liczba rdzeni", "Taktowanie", "ROM", "Typ dysku","RAM", "Karta graficzna", "Pamięć GPU", "System", "Napęd"};

            JTable jt=new JTable(data,column);
        JScrollPane sp = new JScrollPane(jt);
        sp.setPreferredSize(new Dimension(1500, 400));
        sp.setAlignmentX(LEFT_ALIGNMENT);

            panel1.add(sp);

                f.add(panel1);
                f.setSize(1500,500);
                f.setVisible(true);
        JButton button2 = new JButton();



         button2.setText("Eksportuj do pliku txt");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Exporter exporter = new Exporter();
                exporter.exportDataFromJTable(jt,f);
            }
        });

        JButton button3 = new JButton();

        button3.setText("Eksportuj do pliku xml");
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                Exporter exporter = new Exporter();
                exporter.exportDataFromJTable(jt,f);

                File file = new File("outputData.txt");
                FileReader fileReader = new FileReader();

                Formatter formatter = new Formatter();
                File  formattedFile = formatter.formatOutputAsInput(file);

                ArrayList<String> txtLaptops = fileReader.readTxtFile(formattedFile);
                ArrayList<Laptop> laptopsPom= new ArrayList<>();

                LaptopCreator laptopCreator = new LaptopCreator();
                laptopsPom = laptopCreator.createComputerSet(txtLaptops);

                XmlExporter xmlExporter = new XmlExporter();
                try {
                    xmlExporter.crerateXmlFile(laptopsPom);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JPanel panel=new JPanel();

        panel.add(button2);
        panel.add(button3);
        f.add(panel);


        }



}
