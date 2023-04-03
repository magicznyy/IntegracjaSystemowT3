import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LaptopCreator {

    public ArrayList<Laptop> createComputerSet(ArrayList<String> laptopsTxt){
        ArrayList<Laptop> laptops = new ArrayList<>();
        for (String line: laptopsTxt
             ) {

            String[] strArr = line.split(";");
            strArr = avoidingLastCharactersFix(strArr);

            Disc disc = new Disc(strArr[9], strArr[10]);
            GraphicCard graphicCard = new GraphicCard(strArr[11], strArr[12]);
            Processor processor = new Processor(strArr[5], strArr[6], strArr[7]);
            boolean touchScreen = false;
            if (strArr[4] == "tak")
                touchScreen = true;
            Screen screen = new Screen(strArr[1], strArr[2], strArr[3], touchScreen);
            Laptop laptop = new Laptop(strArr[0], strArr[8], processor, disc, screen, graphicCard, strArr[13], strArr[14]);

            laptops.add(laptop);
        }
        return laptops;
    }

    public String [] avoidingLastCharactersFix(String [] strArr){
        String [] strArr2 = new String[15];
        int i=0;
        if(strArr.length<15) {
            for (String s : strArr
            ) {
                strArr2[i] = strArr[i];
                i++;
            }
            strArr=strArr2;
        }
        return  strArr;
    }
}
