public class Processor {

    private String name;
    private String coresNumber;

    private String clocking;

    public Processor(String name, String coresNumber, String clocking) {
        this.name = name;
        this.coresNumber = coresNumber;
        this.clocking = clocking;
    }


    public String getName() {
        return name;
    }

    public String getCoresNumber() {
        return coresNumber;
    }

    public String getClocking() {
        return clocking;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "name='" + name + '\'' +
                ", coresNumber='" + coresNumber + '\'' +
                ", clocking='" + clocking + '\'' +
                '}';
    }
}
