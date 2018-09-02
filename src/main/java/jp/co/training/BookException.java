package jp.co.training;

public class BookException extends Exception {

    private final int actualLength;

    public BookException(String message, int actualLength) {
        super(message);
        this.actualLength = actualLength;
    }

    public int getActualLength() {
        return actualLength;
    }

}
