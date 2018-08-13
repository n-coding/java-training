package jp.co.training;

import java.util.List;

public final class ExitCommand implements Command {

    private List<String> argments;
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void setArgments(List<String> argments) {
        this.argments = argments;
    }

    @Override
    public Result validate() {
        Result result = new Result();
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
