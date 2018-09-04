package jp.co.training;

import static jp.co.training.Main.*;

public final class ExitCommand extends Command {

    public ExitCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String command, String[] argments) {
        CommandResult result = new CommandResult();
        result.addMessage(config.endMessage);
        result.setExit(true);
        return result;
    }

}
