import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class Converter {

    public void fillXmlFile(ArrayList<Laptop> laptops, Document doc){

        for (Laptop laptop: laptops) {
            rootElement2.setAttribute("id", "1002");
        }
    }

    public void crerateEmptyXmlFile() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("laptops");
        doc.appendChild(rootElement);

        Element rootElement2 =  doc.createElement("laptop");
        rootElement.appendChild(doc.createElement("laptop"));

        doc.createElement("brand");
        rootElement2.appendChild(doc.createElement("brand"));

        doc.createElement("ramMemory");
        rootElement2.appendChild(doc.createElement("ramMemory"));

        Element processor = doc.createElement("processor");
        processor.appendChild(doc.createElement("processor"));

        doc.createElement("procName");
        processor.appendChild(doc.createElement("procName"));

        doc.createElement("coresNumber");
        processor.appendChild(doc.createElement("coresNumber"));

        doc.createElement("clocking");
        processor.appendChild(doc.createElement("clocking"));


        Element disc = doc.createElement("disc");
        rootElement2.appendChild(doc.createElement("disc"));

        doc.createElement("discType");
        disc.appendChild(doc.createElement("discType"));

        doc.createElement("capacity");
        disc.appendChild(doc.createElement("capacity"));



        Element screen = doc.createElement("screen");
        rootElement2.appendChild(doc.createElement("screen"));

        doc.createElement("diagonal");
        screen.appendChild(doc.createElement("diagonal"));

        doc.createElement("resolution");
        screen.appendChild(doc.createElement("resolution"));

        doc.createElement("type");
        screen.appendChild(doc.createElement("type"));

        doc.createElement("isTouchScreen");
        screen.appendChild(doc.createElement("isTouchScreen"));



        Element graphicCard = doc.createElement("graphicCard");
        rootElement2.appendChild(doc.createElement("graphicCard"));

        doc.createElement("gpuName");
        graphicCard.appendChild(doc.createElement("gpuNname"));

        doc.createElement("gpuMemory");
        graphicCard.appendChild(doc.createElement("gpuMemory"));



        doc.createElement("operatingSystem");
        rootElement2.appendChild(doc.createElement("operatingSystem"));

        doc.createElement("cdDrive");
        rootElement2.appendChild(doc.createElement("cdDrive"));




    }


}
