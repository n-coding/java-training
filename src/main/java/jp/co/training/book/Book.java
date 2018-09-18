package jp.co.training.book;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jp.co.training.common.Entity;
import jp.co.training.common.Status;
import jp.co.training.util.BookUtil;
import jp.co.training.validate.ItemValidater;

public class Book extends Entity {

    public static final int NUMBER_OF_ITEMS = 6;

    private String id;
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private String publicationDate;
    private String price;

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
        this.id = builder.id;
        this.isbn = builder.isbn;
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.publicationDate = builder.publicationDate;
        this.price = builder.price;
        this.createUser = builder.createUser;
        this.createdDate = builder.createdDate;
        this.updateUser = builder.updateUser;
        this.updatedDate = builder.updatedDate;
    }

    public static final int NUM_ISBN = 0;
    public static final int NUM_BOOK_NAME = 1;
    public static final int NUM_AUTHOR = 2;
    public static final int NUM_PUBLISHER = 3;
    public static final int NUM_PRICE = 4;
    public static final int NUM_PUBLICATION_DATE = 5;

    public static BookResult createBook(String[] argments) {

        BookResult result = new BookResult();

        //各項目のバリデーション

        // isbn
        ItemValidater.checkLength(argments[NUM_ISBN], 1, MAX_ISBN).ifPresent(code -> result.addCode("ISBM", code));

        // bookName
        ItemValidater.checkLength(argments[NUM_BOOK_NAME], 1, MAX_BOOK_NAME)
                .ifPresent(code -> result.addCode("BOOK_NAME", code));

        // author
        ItemValidater.checkLength(argments[NUM_AUTHOR], 1, MAX_AUTHOR)
                .ifPresent(code -> result.addCode("AUTHOR", code));

        // publisher
        ItemValidater.checkLength(argments[NUM_PUBLISHER], 1, MAX_PUBLISHER)
                .ifPresent(code -> result.addCode("PUBLISHER", code));

        // price
        ItemValidater.checkLength(argments[NUM_PRICE], 1, MAX_PRICE)
                .ifPresent(code -> result.addCode("PRICE", code));
        ItemValidater.checkNumber(argments[NUM_PRICE]).ifPresent(code -> result.addCode("PRICE", code));

        // publicationDate
        ItemValidater.checkDatePattern(argments[NUM_PUBLICATION_DATE], DATE_PATTERN)
                .ifPresent(code -> result.addCode("PUBLICATION_DATE", code));

        if (!result.getItemCodes().isEmpty()) {
            return result;
        }

        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

        Book book = new Book.Builder()
                .id(BookUtil.generateID(ID_LENGTH))
                .isbn(argments[NUM_ISBN])
                .bookName(argments[NUM_BOOK_NAME])
                .author(argments[NUM_AUTHOR])
                .publisher(argments[NUM_PUBLISHER])
                .publicationDate(argments[NUM_PUBLICATION_DATE])
                .price(argments[NUM_PRICE])
                .createUser(config.userName)
                .createdDate(today)
                .updateUser(config.userName)
                .updatedDate(today)
                .build();

        result.setBook(book);
        result.setStatus(Status.OK);
        return result;
    }

    public static class Builder {

        private String id;
        private String isbn;
        private String bookName;
        private String author;
        private String publisher;
        private String publicationDate;
        private String price;
        private String createUser;
        private String createdDate;
        private String updateUser;
        private String updatedDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

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

        public Builder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }

        public Builder createdDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

        public Builder updatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

    @Override
    public String encode() {
        return String.join(config.delimiter,
                this.id,
                this.isbn,
                this.bookName,
                this.author,
                this.publisher,
                this.publicationDate,
                this.price,
                this.createUser,
                this.createdDate,
                this.updateUser,
                this.updatedDate);
    }

    public static Book decode(String params) {
        return null;//TODO Bookを返却するように修正
    }

    public List<String> output(String[] cols) {

        List<String> list = new ArrayList<>();
        //TODO 作成中
        for (int i = 0; i < cols.length; i++) {
            switch (Book.BookCol.valueOf(cols[i])) {
            case ID:
                list.add(this.id);
                break;
            case ISBN:
                list.add(this.isbn);
                break;
            default:

            }
        }

        return list;
    }

    public enum BookCol {
        ID, ISBN, BOOK_NAME, AUTHOR, PUBLISHER, PUBLICATION_DATE, PRICE, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE
    }
}
