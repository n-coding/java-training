package jp.co.training;

import static jp.co.training.Main.*;

public class BookRecord {

    private static final int NUMBER_OF_ITEMS = 11;

    private String id;
    private Book book;
    private String createUser;
    private String createdDate;
    private String updateUser;
    private String updatedDate;

    private BookRecord(Builder builder) {
        this.id = builder.id;
        this.book = builder.book;
        this.createUser = builder.createUser;
        this.createdDate = builder.createdDate;
        this.updateUser = builder.updateUser;
        this.updatedDate = builder.updatedDate;
    }

    public static BookRecord decode(String[] argments) throws BookException {

        // パラメータ数チェック
        if (argments.length != NUMBER_OF_ITEMS) {
            throw new BookException("SyntaxError. The number of arguments does not match.", argments.length);
        }

        //BookRecordオブジェクト生成
        return new BookRecord.Builder()
                .id(argments[0])
                .book(new Book.Builder()
                        .isbn(argments[1])
                        .bookName(argments[2])
                        .author(argments[3])
                        .publisher(argments[4])
                        .publicationDate(argments[5])
                        .price(argments[6]).build())
                .createUser(argments[7])
                .createdDate(argments[8])
                .updateUser(argments[9])
                .updatedDate(argments[10]).build();
    }

    public static String encode(BookRecord bookRecord) {
        return bookRecord.toString();
    }

    public static class Builder {
        private String id;
        private Book book;
        private String createUser;
        private String createdDate;
        private String updateUser;
        private String updatedDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder book(Book book) {
            this.book = book;
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

        public BookRecord build() {
            return new BookRecord(this);
        }

    }

    @Override
    public String toString() {
        return String.join(config.delimiter,
                this.id,
                this.book.toString(),
                this.createUser,
                this.createdDate,
                this.updateUser,
                this.updatedDate);
    }
}
