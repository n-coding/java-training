package jp.co.training;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jp.co.training.Const.SAVE_FILE;

public final class InsertCommand implements Command {

    private List<String> argments;

    private Book book;

    @Override
    public void setArgments(List<String> argments) {
        this.argments = argments;
    }

    @Override
    public void execute() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SAVE_FILE, true), StandardCharsets.UTF_8))) {
            for (int i = 0, size = argments.size(); i < size; i++) {
                bw.write((i == 0 ? "" : ",") + argments.get(i).trim());
            }
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("inserted.");
    }

    @Override
    public Result validate() {
        Result result = new Result();
        //パラメータ数
        if (argments.size() != 6) {
            result.addErrMessage("SyntaxError. The number of arguments does not match.");
        }
        book = new Book.Builder().isbn(argments.get(0).trim())
                .bookName(argments.get(1).trim())
                .author(argments.get(2).trim())
                .publisher(argments.get(3).trim())
                .publicationDate(argments.get(4).trim())
                .price(argments.get(5).trim())
                .build();
        result.getErrMesages().addAll(book.validate().getErrMesages());

        return result;
    }

}
