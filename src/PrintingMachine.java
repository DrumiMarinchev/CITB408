import Exceptions.InsufficientPaperException;
import Exceptions.InvalidMachineException;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class PrintingMachine implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int maxPaperCapacity;
    private int pagesPerMinute;
    private boolean color; // true for color, false for B/W
    private List<Publication> printedPublications;
    private int currentPaperLoad; // текущ брой заредени листове хартия

    public PrintingMachine(int maxPaperCapacity, int pagesPerMinute, boolean color) {
        this.maxPaperCapacity = maxPaperCapacity;
        this.pagesPerMinute = pagesPerMinute;
        this.color = color;
        this.printedPublications = new ArrayList<>();
        this.currentPaperLoad = 0;
    }

    // Getters
    public int getMaxPaperCapacity() {
        return maxPaperCapacity;
    }

    public int getPagesPerMinute() {
        return pagesPerMinute;
    }

    public boolean isColor() {
        return color;
    }

    public List<Publication> getPrintedPublications() {
        return printedPublications;
    }

    public int getCurrentPaperLoad() {
        return currentPaperLoad;
    }

    // Setters
    public void setMaxPaperCapacity(int maxPaperCapacity) {
        this.maxPaperCapacity = maxPaperCapacity;
    }

    public void setPagesPerMinute(int pagesPerMinute) {
        this.pagesPerMinute = pagesPerMinute;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setPrintedPublications(List<Publication> printedPublications) {
        this.printedPublications = printedPublications;
    }

    public void setCurrentPaperLoad(int currentPaperLoad) {
        this.currentPaperLoad = currentPaperLoad;
    }

    // Adding more paper and checking if it exceeds the machine's capacity
    public void loadPaper(Paper paper, int sheets) throws InsufficientPaperException {
        if (currentPaperLoad + sheets > maxPaperCapacity) {
            throw new InsufficientPaperException("The machine cannot hold more than " + maxPaperCapacity + " sheets!");
        }
        currentPaperLoad += sheets;
        // Updating the amount of used paper
        PrintingHouse.getInstance().addPaper(paper);
    }

    // Метод за печатане на издание
    public void printPublication(Publication publication, boolean isColor) throws InvalidMachineException, InsufficientPaperException {
        if (isColor != this.color) {
            throw new InvalidMachineException("This machine cannot print in the required color mode.");
        }
        int sheetsNeeded = publication.getPageCount();
        if (currentPaperLoad < sheetsNeeded) {
            throw new InsufficientPaperException("Not enough paper to print the publication.");
        }
        printedPublications.add(publication);
        currentPaperLoad -= sheetsNeeded;
        // Logic for printing publication
    }

    // Метод за връщане на отпечатани страници
    public int getPrintedPages() {
        int totalPages = 0;
        for (Publication publication : printedPublications) {
            totalPages += publication.getPageCount();
        }
        return totalPages;
    }
}

