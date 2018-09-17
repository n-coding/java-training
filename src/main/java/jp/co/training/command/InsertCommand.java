package jp.co.training.command;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;
import static jp.co.training.command.CommandCode.*;

import java.util.Arrays;

import jp.co.training.book.Book;
import jp.co.training.book.BookResult;
import jp.co.training.common.Status;
import jp.co.training.dao.BookDao;
import jp.co.training.dao.DaoResult;

public final class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String command, String argments) {

        CommandResult commandResult = new CommandResult(INSERT);

        //引数をinsert用にパース
        String[] params = argments.split(config.delimiter);
        params = (String[]) Arrays.stream(params).map(e -> e.trim()).toArray(String[]::new);

        // パラメータ数チェック
        if (params.length != Book.NUMBER_OF_ITEMS) {
            commandResult.addCode(WRONG_NUMBER_OF_ARGUMENTS);
            return commandResult;
        }

        //Bookオブジェクト生成
        BookResult bookResult = Book.createBook(params);

        if (bookResult.getStatus() == Status.NG) {
            commandResult.addItemCodes(bookResult.getItemCodes());
            return commandResult;
        }

        //書籍情報の登録
        DaoResult daoResult = new BookDao().insert(bookResult.getBook());
        commandResult.addCodes(daoResult.getCodes());
        commandResult.setStatus(Status.OK);
        return commandResult;
    }

}
