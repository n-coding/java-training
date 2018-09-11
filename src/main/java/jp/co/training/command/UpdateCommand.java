package jp.co.training.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jp.co.training.book.Book;

public class UpdateCommand extends Command {

    public UpdateCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String command, String[] argments) {
        CommandResult result = new CommandResult();
        String suffix = ".tmp" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));

        Book updateBook = null;
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

        return result;
    }

}
