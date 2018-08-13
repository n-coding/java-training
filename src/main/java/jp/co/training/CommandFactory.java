package jp.co.training;

import static jp.co.training.Const.EXIT;
import static jp.co.training.Const.INSERT;

public final class CommandFactory {

    public static Command createCommand(String command) {

        switch (command) {
            case INSERT:
                return new InsertCommand();
            case EXIT:
                return new ExitCommand();
            default:
                return new InvalidCommand();
        }
    }
}
