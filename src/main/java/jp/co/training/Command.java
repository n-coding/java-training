package jp.co.training;

public abstract class Command {

    protected String name;

    protected Command next;

    public Command(String name) {
        this.name = name;
    }

    public Result execute(String command, String[] argments) {
        if (command.equals(name)) {
            return executeCommand(command, argments);
        } else if (next != null) {
            return next.execute(command, argments);
        }
        // どのコマンドにも合致しなかった場合
        Result result = new Result();
        result.addMessage("Invalid Command.");
        return result;
    };

    public Command setNext(Command next) {
        this.next = next;
        return next;
    }

    public abstract Result executeCommand(String command, String[] argments);

}
