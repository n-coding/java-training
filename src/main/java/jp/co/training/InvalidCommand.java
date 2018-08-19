package jp.co.training;

import java.util.List;

public final class InvalidCommand implements Command {
    private final Result result = new Result();

    @Override
    public void setArgments(List<String> argments) {
    }

    @Override
    public Result execute() {
        return result;
    }

    @Override
    public Result validate() {
        result.setCode(StatusCode.CONTINUE);
        result.addErrMessage("Invalid Command.");
        return result;
    }

}
