import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laptop {

    private String brand;
    private String ramMemory;
    private Processor processor;
    private Disc disc;
    private Screen screen;
    private GraphicCard graphicCard;
    private String OperatingSystem;
    private String driveName;

    private String [] laptopTxt;

    public Laptop(String brand, String ramMemory, Processor processor, Disc disc, Screen screen, GraphicCard graphicCard, String operatingSystem, String cdDriveName) {
        this.brand = brand;
        this.ramMemory = ramMemory;
        this.processor = processor;
        this.disc = disc;
        this.screen = screen;
        this.graphicCard = graphicCard;
        OperatingSystem = operatingSystem;
        this.driveName = cdDriveName;
        this.laptopToStringArray();
    }

    public String[] getLaptopTxt() {
        return laptopTxt;
    }

    public String getBrand() {
        return brand;
    }

    public String getRamMemory() {
        return ramMemory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Disc getDisc() {
        return disc;
    }

    public Screen getScreen() {
        return screen;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public String getDriveName() {
        return driveName;
    }

    public List<String> laptopToStringArray(){
        String [] laptop = new String [15];
        laptop[0] = this.getBrand();
        laptop[1] = this.getScreen().getDiagonal();
        laptop[2] = this.getScreen().getResolution();
        laptop[3] = this.getScreen().getType();
        laptop[4] = String.valueOf(this.getScreen().isTouchScreen());
        laptop[5] = this.getProcessor().getName();
        laptop[6]= this.getProcessor().getCoresNumber();
        laptop[7] = this.getProcessor().getClocking();
        laptop[8] = this.getDisc().getCapacity();
        laptop[9] = this.getDisc().getType();
        laptop[10] = this.getRamMemory();
        laptop[11] = this.getGraphicCard().getName();
        laptop[12] = this.getGraphicCard().getMemory();
        laptop[13] = this.getOperatingSystem();
        laptop[14]= this.getDriveName();

        this.laptopTxt = laptop;

        return Arrays.asList(this.laptopTxt);
    }

    public String laptopToStringLine(){
        String [] laptop = new String [15];
        laptop[0] = this.getBrand();
        laptop[1] = this.getScreen().getDiagonal();
        laptop[2] = this.getScreen().getResolution();
        laptop[3] = this.getScreen().getType();
        laptop[4] = String.valueOf(this.getScreen().isTouchScreen());
        laptop[5] = this.getProcessor().getName();
        laptop[6]= this.getProcessor().getCoresNumber();
        laptop[7] = this.getProcessor().getClocking();
        laptop[8] = this.getDisc().getCapacity();
        laptop[9] = this.getDisc().getType();
        laptop[10] = this.getRamMemory();
        laptop[11] = this.getGraphicCard().getName();
        laptop[12] = this.getGraphicCard().getMemory();
        laptop[13] = this.getOperatingSystem();
        laptop[14]= this.getDriveName();

        StringBuilder strb = new StringBuilder();
        int counter = 0;
        for (String s:laptop
        ) {
            strb.append(laptop[counter]);
            if(counter!=14)
                strb.append(";");
            counter++;
        }

        return strb.toString();
    }

    @Override
    public String toString() {
        return  brand + '\t'
                 + ramMemory + '\t'
                 + processor.toString() + '\t'+
                 disc.toString() + '\t'+
                screen.toString() + '\t' +
                 graphicCard.toString() + '\t'+
                 OperatingSystem + '\t' +
                 driveName + '\t';
    }
}
