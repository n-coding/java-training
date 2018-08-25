package jp.co.training;

public final class ExitCommand extends Command {

	public ExitCommand(String name) {
		super(name);
	}

	@Override
	public Result executeCommand(String command, String[] argments) {
		Result result = new Result();
		result.setExit(true);
		return result;
	}

}
