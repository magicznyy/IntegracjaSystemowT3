import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;

public class XmlExporter {

    public void crerateXmlFile(ArrayList<Laptop>laptops) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("laptops");
        rootElement.setAttribute("mod_date", rand.toString());
        doc.appendChild(rootElement);

        int counter = 1;
        for (Laptop laptop:laptops) {
            Element rootElement2 =  doc.createElement("laptop");
            rootElement2.setAttribute("id",Integer.toString(counter));
            rootElement.appendChild(rootElement2);


            Element brand = doc.createElement("brand");
            brand.setTextContent(laptop.getBrand());
            rootElement2.appendChild(brand);


            Element ramMemory = doc.createElement("ramMemory");
            ramMemory.setTextContent(laptop.getRamMemory());
            rootElement2.appendChild(ramMemory);



            Element processor = doc.createElement("processor");
            rootElement2.appendChild(processor);

            Element procName = doc.createElement("procName");
            procName.setTextContent(laptop.getProcessor().getName());
            processor.appendChild(procName);


            Element coresNumber= doc.createElement("coresNumber");
            coresNumber.setTextContent(laptop.getProcessor().getCoresNumber());
            processor.appendChild(coresNumber);


            Element clocking = doc.createElement("clocking");
            clocking.setTextContent(laptop.getProcessor().getClocking());
            processor.appendChild(clocking);



            Element disc = doc.createElement("disc");
            disc.setAttribute("discType", laptop.getDisc().getType());
            rootElement2.appendChild(disc);


            Element capacity = doc.createElement("capacity");
            capacity.setTextContent(laptop.getDisc().getCapacity());
            disc.appendChild(capacity);



            Element screen = doc.createElement("screen");
            screen.setAttribute("touch", boolToString(laptop.getScreen().isTouchScreen()));
            rootElement2.appendChild(screen);


            Element diagonal = doc.createElement("diagonal");
            diagonal.setTextContent(laptop.getScreen().getDiagonal());



            Element resolution = doc.createElement("resolution");
            resolution.setTextContent(laptop.getScreen().getResolution());



            Element screenType = doc.createElement("screenType");
            screenType.setTextContent(laptop.getScreen().getType());

            screen.appendChild(diagonal);
            screen.appendChild(resolution);
            screen.appendChild(screenType);




            Element graphicCard = doc.createElement("graphicCard");
            rootElement2.appendChild(graphicCard);

            Element gpuName = doc.createElement("gpuName");
            gpuName.setTextContent(laptop.getGraphicCard().getName());
            Element gpuMemory = doc.createElement("gpuMemory");
            gpuMemory.setTextContent(laptop.getGraphicCard().getMemory());

            graphicCard.appendChild(gpuName);
            graphicCard.appendChild(gpuMemory);



            Element os = doc.createElement("operatingSystem");
            os.setTextContent(laptop.getOperatingSystem());
            rootElement2.appendChild(os);


            Element cdDrive= doc.createElement("cdDrive");
            cdDrive.setTextContent(laptop.getDriveName());
            rootElement2.appendChild(cdDrive);


            counter ++;
        }
            try {
                writeXml(doc, "outputData.xml");
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }
    private static void writeXml(Document doc, String s ) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(s);

        transformer.transform(source, result);

    }


    public static String boolToString(Boolean b) {

        if (b)
            return "yes";
        return "no";
    }


    }
