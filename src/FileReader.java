import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<String> readTxtFile(File file){
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


    public ArrayList<Laptop> readXmlFile(File file){
        ArrayList<Laptop> laptops = new ArrayList<>();
        try
        {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("laptop");


            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    Disc disc = new Disc();

                        disc.setCapacity(eElement.getElementsByTagName("capacity").item(0).getTextContent());
                    if(eElement.getAttributeNode("disc") !=  null )
                        disc.setType(eElement.getAttributeNode("disc").toString());
                    else
                        disc.setType("brak");


                    GraphicCard graphicCard = new GraphicCard(eElement.getElementsByTagName("gpuName").item(0).getTextContent(),eElement.getElementsByTagName("gpuMemory").item(0).getTextContent());
                        Processor processor = new Processor(eElement.getElementsByTagName("procName").item(0).getTextContent(), eElement.getElementsByTagName("coresNumber").item(0).getTextContent(), eElement.getElementsByTagName("clocking").item(0).getTextContent());

                        boolean touchScreen = false;
                        if (eElement.getAttribute("touch")== "tak")
                            touchScreen = true;
                        Screen screen = new Screen(eElement.getElementsByTagName("diagonal").item(0).getTextContent(), eElement.getElementsByTagName("resolution").item(0).getTextContent(), eElement.getElementsByTagName("screenType").item(0).getTextContent(), touchScreen);
                        Laptop laptop = new Laptop(eElement.getElementsByTagName("brand").item(0).getTextContent(), eElement.getElementsByTagName("ramMemory").item(0).getTextContent(), processor, disc, screen, graphicCard, eElement.getElementsByTagName("cdDrive").item(0).getTextContent(), eElement.getElementsByTagName("operatingSystem").item(0).getTextContent());

                    laptops.add(laptop);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return laptops;
    }


    public String[] createLaptopsArray(ArrayList<Laptop> laptops){

        ArrayList <String> laptopsArr = new ArrayList<>();
        laptopsArr.toArray();
        for (Laptop l : laptops
        ) {
            laptopsArr.addAll(l.laptopToStringArray());
        }

        return (String[])laptopsArr.toArray();
    }



}





