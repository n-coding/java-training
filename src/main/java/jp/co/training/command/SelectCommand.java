package jp.co.training.command;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

import java.util.List;

import jp.co.training.book.Book;
import jp.co.training.dao.BookDao;
import jp.co.training.dao.SelectDaoResult;

public class SelectCommand extends Command {

    public SelectCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String argments) {

        CommandResult result = new CommandResult(SELECT);

        //TODO argments解析
        //orderbyまでを取り出し、それ以前を,区切りで配列にする、それ以降を空白区切りで配列にする

        String[] cols;
        String[] orderCols;
        if (argments.toLowerCase().indexOf("orderby") == -1) {
            cols = argments.split(config.delimiter);
        } else {
            cols = argments.substring(0, argments.toLowerCase().indexOf(ORDERBY)).split(config.delimiter);
            orderCols = argments.substring(argments.toLowerCase().indexOf(ORDERBY) + 1).split(config.delimiter);
        }

        //colsのバリデーション

        //
        SelectDaoResult<Book> daoResult = new BookDao().select();
        List<Book> records = daoResult.getRecords();

        for (Book book : records) {
            result.addRecord((book.output(cols)));
        }
        return result;
    }

}
