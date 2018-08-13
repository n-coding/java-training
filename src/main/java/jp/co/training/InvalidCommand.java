package jp.co.training;

import java.util.List;

public final class InvalidCommand implements Command {

    @Override
    public void setArgments(List<String> argments) {
    }

    @Override
    public void execute() {
    }

    @Override
    public Result validate() {
        Result result = new Result();
        result.addErrMessage("Invalid Command.");
        return result;
    }

}
