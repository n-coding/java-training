package jp.co.training;

import static jp.co.training.Main.config;

public final class ExitCommand extends Command {

	public ExitCommand(String name) {
		super(name);
	}

	@Override
	public Result executeCommand(String command, String[] argments) {
		Result result = new Result();
		result.addMessage(config.endMessage);
		result.setExit(true);
		return result;
	}

}
