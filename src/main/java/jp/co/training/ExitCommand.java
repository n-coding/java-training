package jp.co.training;

public final class ExitCommand implements Command {

    private final Result result = new Result();

    @Override
    public Result execute() {
        result.setExit(true);
        return result;
    }

    @Override
    public void setArgments(String[] argments) {
    }

}
