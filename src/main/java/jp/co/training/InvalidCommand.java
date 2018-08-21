package jp.co.training;

public final class InvalidCommand extends Command {

    @Override
    public Result execute(String command, String[] argments) {
        result = new Result();
        result.addMessage("Invalid Command.");
        return result;
    }

    @Override
    public Command setNext(Command next) {
        throw new UnsupportedOperationException();
    }
}
