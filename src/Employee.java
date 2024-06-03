import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
        protected String name;
        protected double baseSalary;

        public Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }
    }
