package jp.co.training.command;

import jp.co.training.Code;

public abstract class Command {

    protected String name;

    protected Command next;

    public Command(String name) {
        this.name = name;
    }

    public CommandResult execute(String command, String[] argments) {
        if (command.equals(name)) {
            return executeCommand(command, argments);
        } else if (next != null) {
            return next.execute(command, argments);
        }
        // どのコマンドにも合致しなかった場合
        CommandResult result = new CommandResult();
        result.addCode(Code.INVALID_COMMAND);
        return result;
    }

    public Command setNext(Command next) {
        this.next = next;
        return next;
    }

    public abstract CommandResult executeCommand(String command, String[] argments);

}