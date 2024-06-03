import java.io.Serial;
import java.io.Serializable;

public class Operator extends Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Operator(String name, double baseSalary) {
        super(name, baseSalary);
    }
}
