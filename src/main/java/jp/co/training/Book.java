package jp.co.training;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

public class Book {

    private static final int NUMBER_OF_ITEMS = 6;

    private final String isbn;
    private final String bookName;
    private final String author;
    private final String publisher;
    private final String publicationDate;
    private final String price;

    public Result validate() {
        Result result = new Result();

        // isbn
        BookUtil.checkLength(isbn, 1, MAX_ISBN).ifPresent(msg -> result.addMessage("ISBM:" + msg));

        // bookName
        BookUtil.checkLength(bookName, 1, MAX_BOOK_NAME).ifPresent(msg -> result.addMessage("BOOK_NAME:" + msg));

        // author
        BookUtil.checkLength(author, 1, MAX_AUTHOR).ifPresent(msg -> result.addMessage("AUTHOR" + msg));

        // publisher
        BookUtil.checkLength(publisher, 1, MAX_PUBLISHER).ifPresent(msg -> result.addMessage("PUBLISHER:" + msg));

        // price
        BookUtil.checkLength(price, 1, MAX_PRICE).ifPresent(msg -> result.addMessage("PRICE:" + msg));
        BookUtil.checkNumber(price).ifPresent(msg -> result.addMessage("PRICE:" + msg));

        // publicationDate
        BookUtil.checkDatePattern(publicationDate, DATE_PATTERN)
                .ifPresent(msg -> result.addMessage("PUBLICATION_DATE:" + msg));

        return result;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getPrice() {
        return price;
    }

    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.publicationDate = builder.publicationDate;
        this.price = builder.price;
    }

    public static Book createBook(String[] argments) throws BookException {
        // パラメータ数チェック
        if (argments.length != NUMBER_OF_ITEMS) {
            throw new BookException("SyntaxError. The number of arguments does not match.", argments.length);
        }

        return new Book.Builder()
                .isbn(argments[0])
                .bookName(argments[1])
                .author(argments[2])
                .publisher(argments[3])
                .publicationDate(argments[4])
                .price(argments[5]).build();
    }

    public static class Builder {

        private String isbn;
        private String bookName;
        private String author;
        private String publisher;
        private String publicationDate;
        private String price;

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder publicationDate(String publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

    @Override
    public String toString() {
        return String.join(config.delimiter,
                this.isbn,
                this.bookName,
                this.author,
                this.publisher,
                this.publicationDate,
                this.price);
    }
}
