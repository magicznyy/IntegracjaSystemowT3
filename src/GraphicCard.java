public class GraphicCard {

    private String name;
    private String memory;

    public GraphicCard(String name, String memory) {
        this.name = name;
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public String getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "GraphicCard{" +
                "name='" + name + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
