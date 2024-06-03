import java.io.Serial;
import java.io.Serializable;

public class Paper implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
        private String type;
        private String size;
        private Double basePrice;

        public Paper(String type, String size, double basePrice) {
            this.type = type;
            this.size = size;
            this.basePrice = basePrice;
        }

        // Getters
        public String getType() {
            return type;
        }

        public String getSize() {
            return size;
        }

        public double getBasePrice() {
            return basePrice;
        }

        // Setters
        public void setType(String type) {
            this.type = type;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void setBasePrice(double basePrice) {
            this.basePrice = basePrice;
        }

        public double calculatePrice() {
            double price = basePrice;
            switch (size) {
                case "A4":
                    price *= 1.2;
                    break;
                case "A3":
                    price *= 1.5;
                    break;
                case "A2":
                    price *= 2.0;
                    break;
                case "A1":
                    price *= 3.0;
                    break;
            }
            return price;
        }
    }
