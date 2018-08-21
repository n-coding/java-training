package jp.co.training;

import static jp.co.training.Const.EXIT;

public final class ExitCommand extends Command {

    @Override
    public Result execute(String command, String[] argments) {
        result = new Result();
        if (command.equals(EXIT)) {
            result.setExit(true);
            return result;
        }
        return next.execute(command, argments);
    }

}
