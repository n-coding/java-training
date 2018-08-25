package jp.co.training;

import static jp.co.training.Const.DELIMITER;
import static jp.co.training.Const.EXIT;
import static jp.co.training.Const.INSERT;
import static jp.co.training.Const.PROMPT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public final class Main {

	public static void main(String... args) throws FileNotFoundException, IOException {
		Command command = new InsertCommand(INSERT);
		command.setNext(new ExitCommand(EXIT));
		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				System.out.print(PROMPT);
				String inputCommand = scan.next().toLowerCase();
				String[] argments = scan.nextLine().split(DELIMITER);
				argments = (String[]) Arrays.stream(argments).map(e -> e.trim()).toArray();

				// コマンド実行
				Result result = command.execute(inputCommand, argments);
				outputMessages(result);
				if (result != null && result.isExit()) {
					break;
				}
			}
		}
	}

	private static void outputMessages(Result result) {
		if (result != null && result.getMesages().size() > 0) {
			result.getMesages().stream().forEach(message -> {
				System.out.println(message);
			});
		}
	}
}
