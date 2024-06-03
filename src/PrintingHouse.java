import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;


public class PrintingHouse implements Serializable {
                @Serial
                private static final long serialVersionUID = 1L;
                private static PrintingHouse instance;

                public static PrintingHouse getInstance() {
                    if (instance == null) {
                        instance = new PrintingHouse();
                    }
                    return instance;
                }
                    private List<Employee> employees;
                    private List<PrintingMachine> machines;
                    private List<Publication> publications;
                    private Map<String, Double> basePaperPrices; // тип на хартия -> базова цена
                    private double revenue;
                    private double expenses;
                    private List<Paper> usedPaper; // List of used paper

                    public PrintingHouse() {
                        this.employees = new ArrayList<>();
                        this.machines = new ArrayList<>();
                        this.publications = new ArrayList<>();
                        this.basePaperPrices = new HashMap<>();
                        this.revenue = 0;
                        this.expenses = 0;
                        this.usedPaper = new ArrayList<>();
                    }

                    // Getters
                    public List<Employee> getEmployees() {
                        return employees;
                    }

                    public List<PrintingMachine> getMachines() {
                        return machines;
                    }

                    public List<Publication> getPublications() {
                        return publications;
                    }

                    public Map<String, Double> getBasePaperPrices() {
                        return basePaperPrices;
                    }

                    public double getRevenue() {
                        return revenue;
                    }

                    public double getExpenses() {
                        return expenses;
                    }

                    public List<Paper> getUsedPaper() {
                        return usedPaper;
                    }

                    // Setters
                    public void setEmployees(List<Employee> employees) {
                        this.employees = employees;
                    }

                    public void setMachines(List<PrintingMachine> machines) {
                        this.machines = machines;
                    }

                    public void setPublications(List<Publication> publications) {
                        this.publications = publications;
                    }

                    public void setBasePaperPrices(Map<String, Double> basePaperPrices) {
                        this.basePaperPrices = basePaperPrices;
                    }

                    public void setRevenue(double revenue) {
                        this.revenue = revenue;
                    }

                    public void setExpenses(double expenses) {
                        this.expenses = expenses;
                    }

                    public void setUsedPaper(List<Paper> usedPaper) {
                        this.usedPaper = usedPaper;
                    }

                    // Метод за изчисление на разходите
                    public void calculateExpenses() {
                        expenses = 0;
                        for (Employee employee : employees) {
                            expenses += employee.getBaseSalary();
                        }

                        for (Paper paper : usedPaper) {
                            expenses += paper.calculatePrice();
                        }
                    }

                    // Calculating the revenue
                    public void calculateRevenue() {
                        revenue = 0;
                        for (Publication publication : publications) {
                            double pricePerCopy = publication.getPricePerCopy();
                            int copiesPrinted = publication.getCopiesPrinted();
                            double publicationRevenue = calculatedPublicationRevenue(pricePerCopy, copiesPrinted);
                            revenue += publicationRevenue;
                        }
                    }
                    private double calculatedPublicationRevenue(double pricePerCopy, int copiesPrinted) {
                        double totalRevenue = pricePerCopy * copiesPrinted;
                        int discountThreshold = 500;
                        double discountPercentage = 0.15;
                        if (copiesPrinted > discountThreshold) {
                            double discountAmount = totalRevenue * discountPercentage;
                            totalRevenue -= discountAmount;

                        }
                        return totalRevenue;
                    }

                    // Метод за добавяне на служител
                    public void addEmployee(Employee employee) {
                        employees.add(employee);
                    }

                    // Метод за добавяне на машина
                    public void addMachine(PrintingMachine machine) {
                        machines.add(machine);
                    }

                    // Метод за добавяне на издание
                    public void addPublication(Publication publication) {
                        publications.add(publication);
                    }

                    // Метод за добавяне на хартия и обновяване на разходите за хартия
                    public void addPaper(Paper paper) {
                        usedPaper.add(paper);
                        expenses += paper.calculatePrice();
                    }

                    // Метод за записване на данни във файл
                public void saveToFile(String filename) {
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                        outputStream.writeObject(employees);
                        outputStream.writeObject(machines);
                        outputStream.writeObject(publications);
                        outputStream.writeObject(basePaperPrices);
                        outputStream.writeDouble(revenue);
                        outputStream.writeDouble(expenses);
                        outputStream.writeObject(usedPaper);
                        System.out.println("Data saved successfully.");
                    } catch (IOException e) {
                        System.err.println("Error saving data to file: " + e.getMessage());
                    }
                }

                    // Метод за четене на данни от файл
                public void readFromFile(String filename) {
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
                        employees = (List<Employee>) inputStream.readObject();
                        machines = (List<PrintingMachine>) inputStream.readObject();
                        publications = (List<Publication>) inputStream.readObject();
                        basePaperPrices = (Map<String, Double>) inputStream.readObject();
                        revenue = inputStream.readDouble();
                        expenses = inputStream.readDouble();
                        usedPaper = (List<Paper>) inputStream.readObject();
                        System.out.println("Data read successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error reading data from file: " + e.getMessage());
                    }
                }
            }