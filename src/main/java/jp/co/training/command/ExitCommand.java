package jp.co.training.command;

import static jp.co.training.Const.*;

public final class ExitCommand extends Command {

    public ExitCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String argments) {
        CommandResult result = new CommandResult(EXIT);
        //TODO 以下の処理はviewerクラスに任せる
        //        result.addMessage(config.endMessage);
        result.setExit(true);
        return result;
    }

}
