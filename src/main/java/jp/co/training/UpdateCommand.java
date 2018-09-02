package jp.co.training;

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

        Path saveFilePath = Paths.get(config.saveFile);
        Path tmpFilePath = Paths.get(config.saveFile + suffix);
        try (BufferedReader reader = Files.newBufferedReader(saveFilePath);
                PrintWriter writer = new PrintWriter(Files.newBufferedWriter(tmpFilePath, StandardCharsets.UTF_8))) {

            String input;
            while ((input = reader.readLine()) != null) {
                BookRecord record = BookRecord.decode(input.split(config.delimiter));
                //TODO 判定や変換処理
                String output = input;
                writer.println(output);
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
