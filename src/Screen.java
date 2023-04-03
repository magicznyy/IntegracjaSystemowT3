public class Screen {

    private String diagonal;
    private String resolution;

    private String type;

    private boolean isTouchScreen;

    public Screen(String diagonal, String resolution, String type, boolean isTouchScreen) {
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.type = type;
        this.isTouchScreen = isTouchScreen;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public String getResolution() {
        return resolution;
    }

    public String getType() {
        return type;
    }

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "diagonal='" + diagonal + '\'' +
                ", resolution='" + resolution + '\'' +
                ", type='" + type + '\'' +
                ", isTouchScreen=" + isTouchScreen +
                '}';
    }
}
