public class Disc {

        private String capacity;
        private String type;

        public Disc(String capacity, String type) {
                this.capacity = capacity;
                this.type = type;
        }

        public Disc() {
        }

        public String getCapacity() {
                return capacity;
        }

        public String getType() {
                return type;
        }

        public void setCapacity(String capacity) {
                this.capacity = capacity;
        }

        public void setType(String type) {
                this.type = type;
        }

        @Override
        public String toString() {
                return "Disc{" +
                        "capacity='" + capacity + '\'' +
                        ", type='" + type + '\'' +
                        '}';
        }
}
