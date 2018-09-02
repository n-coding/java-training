package jp.co.training;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateCommand extends Command {

    public UpdateCommand(String name) {
        super(name);
    }

    @Override
    public Result executeCommand(String command, String[] argments) {
        Result result = new Result();
        String suffix = ".tmp" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));

        Book updateBook = null;
        try {
            updateBook = Book.createBook(argments);
        } catch (BookException e1) {
            result.addMessage(e1.getMessage());
            return result;
        }

        Path saveFilePath = Paths.get(config.saveFile);
        Path tmpFilePath = Paths.get(config.saveFile + suffix);
        try (BufferedReader reader = Files.newBufferedReader(saveFilePath);
                PrintWriter writer = new PrintWriter(Files.newBufferedWriter(tmpFilePath, StandardCharsets.UTF_8))) {

            String recordLine;
            while ((recordLine = reader.readLine()) != null) {
                BookRecord record = BookRecord.decode(recordLine.split(config.delimiter));
                //TODO 判定や変換処理
                if (updateBook.getIsbn().equals(record.getBook().getIsbn())) {
                    String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
                    recordLine = new BookRecord.Builder()
                            .id(record.getId())
                            .book(updateBook)
                            .createUser(record.getCreateUser())
                            .createdDate(record.getCreatedDate())
                            .updateUser(config.userName)
                            .updatedDate(today)
                            .build().toString();
                }
                writer.println(recordLine);
            }
            Files.delete(saveFilePath);
            Files.move(tmpFilePath, saveFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BookException e) {
            result.addMessage("File format is invalid.");
            result.addMessage(e.getMessage());
            return result;
        }

        return result;
    }

}
