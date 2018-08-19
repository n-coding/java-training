package jp.co.training;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import static jp.co.training.Const.SAVE_FILE;

public final class InsertCommand implements Command {

    private final Result result = new Result();
    private String[] argments;
    private Book book;

    @Override
    public void setArgments(String[] argments) {
        this.argments = argments;
    }

    @Override
    public Result execute() {
        if (!validate()) {
            return result;
        }
        return createBook();
    }

    private Result createBook() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SAVE_FILE, true), StandardCharsets.UTF_8))) {
            bw.write(book.getIsbn());
            bw.write(book.getBookName());
            bw.write(book.getAuthor());
            bw.write(book.getPublisher());
            bw.write(book.getPublicationDate());
            bw.write(book.getPrice());
            bw.newLine();
        } catch (IOException ex) {
            result.addMessage(SAVE_FILE + ": cannot open.");
            result.setExit(true);
            return result;
        }
        result.addMessage("inserted.");
        return result;
    }

    /*
     検証の結果OKならtrueを返す。それ以外はfalseを返す
     */
    private boolean validate() {
        //パラメータ数チェック
        if (argments.length != 6) {
            result.addMessage("SyntaxError. The number of arguments does not match.");
            return false;
        }
        //書籍情報のチェック
        book = new Book.Builder().isbn(argments[0].trim())
                .bookName(argments[1].trim())
                .author(argments[2].trim())
                .publisher(argments[3].trim())
                .publicationDate(argments[4].trim())
                .price(argments[5].trim())
                .build();
        result.getMesages().addAll(book.validate().getMesages());
        return result.getMesages().isEmpty();
    }

}
