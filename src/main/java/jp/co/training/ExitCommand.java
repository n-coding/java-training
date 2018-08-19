package jp.co.training;

import java.util.List;

public final class ExitCommand implements Command {

    private final Result result = new Result();

    private List<String> argments;

    @Override
    public Result execute() {
        result.setCode(StatusCode.BREAK);
        return result;
    }

    @Override
    public void setArgments(List<String> argments) {
        this.argments = argments;
    }

    @Override
    public Result validate() {
        //パラメータ数
        if (argments != null && !argments.isEmpty()) {
            if (argments.size() == 1 && argments.get(0).trim().equals("")) {
                return result;
            }
            result.addErrMessage("SyntaxError. The number of arguments does not match.");
        }
        return result;
    }

}
