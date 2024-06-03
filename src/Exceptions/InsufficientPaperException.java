package Exceptions;

public class InsufficientPaperException extends Exception {
    public InsufficientPaperException() {
        super("Insufficient paper available for printing");
    }

    public InsufficientPaperException(String message) {
        super(message);
    }
}

