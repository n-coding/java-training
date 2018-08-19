package jp.co.training;

public final class InvalidCommand implements Command {

    private final Result result = new Result();

    @Override
    public void setArgments(String[] argments) {
    }

    @Override
    public Result execute() {
        result.addMessage("Invalid Command.");
        return result;
    }

}
