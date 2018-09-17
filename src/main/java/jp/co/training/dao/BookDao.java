package jp.co.training.dao;

import static jp.co.training.Main.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import jp.co.training.book.Book;
import jp.co.training.common.Status;

public class BookDao {

    public DaoResult insert(Book book) {

        DaoResult result = new DaoResult();

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get(config.saveFile), StandardCharsets.UTF_8))) {
            writer.println(book.toString());
        } catch (IOException ex) {
            result.addCode(DaoCode.IO_ERROR);
            return result;
        }

        result.setStatus(Status.OK);
        return result;
    }

    public DaoResult select() {
        return null;
    }

    public DaoResult update(String id, Map<String, String> updateParams) {
        //TODO １行ずつ読取、1行ずつ書込

        //        String suffix = ".tmp" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));

        //        Book updateBook = null;
        //        try {
        //            updateBook = Book.createBook(argments);
        //        } catch (BookException e1) {
        //            result.addMessage(e1.getMessage());
        //            return result;
        //        }
        //
        //        Path saveFilePath = Paths.get(config.saveFile);
        //        Path tmpFilePath = Paths.get(config.saveFile + suffix);
        //        try (BufferedReader reader = Files.newBufferedReader(saveFilePath);
        //                PrintWriter writer = new PrintWriter(Files.newBufferedWriter(tmpFilePath, StandardCharsets.UTF_8))) {
        //
        //            String recordLine;
        //            while ((recordLine = reader.readLine()) != null) {
        //                BookRecord record = BookRecord.decode(recordLine.split(config.delimiter));
        //                //TODO 判定や変換処理
        //                if (updateBook.getIsbn().equals(record.getBook().getIsbn())) {
        //                    String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        //                    recordLine = new BookRecord.Builder()
        //                            .id(record.getId())
        //                            .book(updateBook)
        //                            .createUser(record.getCreateUser())
        //                            .createdDate(record.getCreatedDate())
        //                            .updateUser(config.userName)
        //                            .updatedDate(today)
        //                            .build().toString();
        //                }
        //                writer.println(recordLine);
        //            }
        //            Files.delete(saveFilePath);
        //            Files.move(tmpFilePath, saveFilePath);
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        } catch (BookException e) {
        //            result.addMessage("File format is invalid.");
        //            result.addMessage(e.getMessage());
        //            return result;
        //        }
        //        return result;

        return null;
    }

}
