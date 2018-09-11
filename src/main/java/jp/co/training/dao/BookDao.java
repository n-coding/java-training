package jp.co.training.dao;

import static jp.co.training.Main.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import jp.co.training.Result;
import jp.co.training.Status;
import jp.co.training.book.Book;
import jp.co.training.Code;

public class BookDao {

    public Result insert(Book book) {

        Result result = new Result();

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get(config.saveFile), StandardCharsets.UTF_8))) {
            writer.println(book.toString());
        } catch (IOException ex) {
            result.addCode(Code.IO_ERROR);
            return result;
        }

        result.setStatus(Status.OK);
        return result;
    }

}
