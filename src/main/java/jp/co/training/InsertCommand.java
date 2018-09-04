package jp.co.training;

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
            commandResult.addMessage("SyntaxError. The number of arguments does not match. expected:"
                    + Book.NUMBER_OF_ITEMS + " but actual:" + argments.length);
            return commandResult;
        }

        //Bookオブジェクト生成
        BookResult bookResult = Book.createBook(argments);

        if (bookResult.getStatus() == Status.NG) {
            commandResult.addMessages(bookResult.getMessages());
            return commandResult;
        }

        //書籍情報の登録
        Result result = new BookDao().insert(bookResult.getBook());
        commandResult.addMessages(result.getMessages());
        commandResult.setStatus(Status.OK);
        return commandResult;
    }

}
