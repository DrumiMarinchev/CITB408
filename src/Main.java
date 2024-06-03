import Exceptions.InsufficientPaperException;
import Exceptions.InvalidMachineException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PrintingHouse printingHouse = PrintingHouse.getInstance();

        // Примери за добавяне на служители, машини и публикации
        Employee operator = new Operator("Иван Иванов", 1500);
        Employee manager = new Manager("Друми Маринчев", 2200, 10, 5000);
        printingHouse.addEmployee(operator);
        printingHouse.addEmployee(manager);

        PrintingMachine machine1 = new PrintingMachine(1000, 50, true);
        PrintingMachine machine2 = new PrintingMachine(800, 40, false);
        printingHouse.addMachine(machine1);
        printingHouse.addMachine(machine2);

        Publication book = new Publication("Първа Книга", 300, "A4", 5, 6000);
        printingHouse.addPublication(book);

        // Примери за зареждане на хартия и печатане на публикации
        try {
            machine1.loadPaper(new Paper("glossy", "A4", 2), 1000);
            machine2.loadPaper(new Paper("normal", "A4", 1), 300);
            machine1.printPublication(book, true);
        } catch (InsufficientPaperException | InvalidMachineException e) {
            e.printStackTrace();
        }

        // Калкулиране на разходите и приходите
        printingHouse.calculateExpenses();
        printingHouse.calculateRevenue();

        System.out.println("Total expenses: " + printingHouse.getExpenses());
        System.out.println("Total revenue: " + printingHouse.getRevenue());

        try {
            printingHouse.saveToFile("printingHouseData.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Създаване на нова инстанция на PrintingHouse за демонстрация на четене от файл
        PrintingHouse newPrintingHouse = PrintingHouse.getInstance();
        try {
            newPrintingHouse.readFromFile("printingHouseData.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the read data
        System.out.println("Data read from file:");
        System.out.println("Total expenses: " + newPrintingHouse.getExpenses());
        System.out.println("Total revenue: " + newPrintingHouse.getRevenue());
    }
}



