import java.io.Serial;
import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
        private double bonusPercentage;
        private double revenueThreshold;

        public Manager(String name, double baseSalary, double bonusPercentage, double revenueThreshold) {
            super(name, baseSalary);
            this.bonusPercentage = bonusPercentage;
            this.revenueThreshold = revenueThreshold;
        }

        // Getters
        public double getBonusPercentage() {
            return bonusPercentage;
        }

        public double getRevenueThreshold() {
            return revenueThreshold;
        }

        // Setters
        public void setBonusPercentage(double bonusPercentage) {
            this.bonusPercentage = bonusPercentage;
        }

        public void setRevenueThreshold(double revenueThreshold) {
            this.revenueThreshold = revenueThreshold;
        }
    }
