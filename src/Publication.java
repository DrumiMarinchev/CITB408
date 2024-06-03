import java.io.Serial;
import java.io.Serializable;

public class Publication implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
        private String title; //title of the publication
        private int pageCount; //number of pages of the publication
        private String pageSize; //page size- А1;А2;А3;А4;А5
        private double pricePerCopy;
        private int copiesPrinted; // amount of copies printed

        public Publication(String title, int pageCount, String pageSize, double pricePerCopy, int copiesPrinted) {
            this.title = title;
            this.pageCount = pageCount;
            this.pageSize = pageSize;
            this.pricePerCopy = pricePerCopy;
            this.copiesPrinted = copiesPrinted;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public int getPageCount() {
            return pageCount;
        }

        public String getPageSize() {
            return pageSize;
        }

        public double getPricePerCopy() {return pricePerCopy;}

        public int getCopiesPrinted() {return copiesPrinted;}

        // Setters
        public void setTitle(String title) {
            this.title = title;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public void setPricePerCopy(double pricePerCopy) {this.pricePerCopy = pricePerCopy;}

        public void setCopiesPrinted(int copiesPrinted) {this.copiesPrinted = copiesPrinted;}
    }
