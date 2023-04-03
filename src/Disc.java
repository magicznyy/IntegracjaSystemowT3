public class Disc {

        private String capacity;
        private String type;

        public Disc(String capacity, String type) {
                this.capacity = capacity;
                this.type = type;
        }

        public String getCapacity() {
                return capacity;
        }

        public String getType() {
                return type;
        }

        @Override
        public String toString() {
                return "Disc{" +
                        "capacity='" + capacity + '\'' +
                        ", type='" + type + '\'' +
                        '}';
        }
}
