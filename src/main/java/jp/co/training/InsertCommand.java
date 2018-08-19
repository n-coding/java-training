package jp.co.training;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import static jp.co.training.Const.SAVE_FILE;

public final class InsertCommand implements Command {

    private final Result result = new Result();

    private List<String> argments;

    private Book book;

    @Override
    public void setArgments(List<String> argments) {
        this.argments = argments;
    }

    @Override
    public Result execute() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SAVE_FILE, true), StandardCharsets.UTF_8))) {
            bw.write(book.getIsbn());
            bw.write(book.getBookName());
            bw.write(book.getAuthor());
            bw.write(book.getPublisher());
            bw.write(book.getPublicationDate());
            bw.write(book.getPrice());
            bw.newLine();
        } catch (IOException ex) {
            System.out.println(SAVE_FILE + ": cannot open.");
        }
        System.out.println("inserted.");
        return result;
    }

    @Override
    public Result validate() {
        //パラメータ数チェック
        if (argments.size() != 6) {
            result.addErrMessage("SyntaxError. The number of arguments does not match.");
            result.setCode(Status.CONTINUE);
            return result;
        }
        //書籍情報のチェック
        book = new Book.Builder().isbn(argments.get(0).trim())
                .bookName(argments.get(1).trim())
                .author(argments.get(2).trim())
                .publisher(argments.get(3).trim())
                .publicationDate(argments.get(4).trim())
                .price(argments.get(5).trim())
                .build();
        result.getMesages().addAll(book.validate().getMesages());
        if (!result.getMesages().isEmpty()) {
            result.setCode(Status.CONTINUE);
        }

        return result;
    }

}
