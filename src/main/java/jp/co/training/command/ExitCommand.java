package jp.co.training.command;

public final class ExitCommand extends Command {

    public ExitCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String command, String[] argments) {
        CommandResult result = new CommandResult();
        //TODO 以下の処理はviewerクラスに任せる
        //        result.addMessage(config.endMessage);
        result.setExit(true);
        return result;
    }

}