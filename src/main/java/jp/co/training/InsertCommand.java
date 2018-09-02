package jp.co.training;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public Result executeCommand(String command, String[] argments) {

        //Bookオブジェクト生成
        Book book = null;
        try {
            book = Book.createBook(argments);
        } catch (BookException e) {
            Result result = new Result();
            result.addMessage(e.getMessage());
            return result;
        }

        // 書籍情報のチェック
        Result result = book.validate();
        if (!result.getMesages().isEmpty()) {
            return result;
        }

        //書籍情報の登録
        return insert(book);
    }

    private Result insert(Book book) {
        Result result = new Result();
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

        String output = new BookRecord.Builder()
                .id(BookUtil.generateID(ID_LENGTH))
                .book(book)
                .createUser(config.userName)
                .createdDate(today)
                .updateUser(config.userName)
                .updatedDate(today)
                .build().toString();

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get(config.saveFile), StandardCharsets.UTF_8))) {
            writer.println(output);
        } catch (IOException ex) {
            result.addMessage(config.saveFile + ": cannot open.");
            result.setExit(true);
            return result;
        }
        result.addMessage("inserted.");
        return result;
    }

}
