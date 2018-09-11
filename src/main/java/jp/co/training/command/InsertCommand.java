package jp.co.training.command;

import static jp.co.training.Code.*;

import jp.co.training.Result;
import jp.co.training.Status;
import jp.co.training.book.Book;
import jp.co.training.book.BookResult;
import jp.co.training.dao.BookDao;

public final class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String command, String[] argments) {

        CommandResult commandResult = new CommandResult();

        // パラメータ数チェック
        if (argments.length != Book.NUMBER_OF_ITEMS) {
            commandResult.addCode(WRONG_NUMBER_OF_ARGUMENTS);
            return commandResult;
        }

        //Bookオブジェクト生成
        BookResult bookResult = Book.createBook(argments);

        if (bookResult.getStatus() == Status.NG) {
            commandResult.addItemCodes(bookResult.getItemCodes());
            return commandResult;
        }

        //書籍情報の登録
        Result result = new BookDao().insert(bookResult.getBook());
        commandResult.addCodes(result.getCodes());
        commandResult.setStatus(Status.OK);
        return commandResult;
    }

}
