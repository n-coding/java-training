package jp.co.training;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static jp.co.training.Const.DELIMITER;
import static jp.co.training.Const.PROMPT;

public final class Main {

    public static void main(String... args) throws FileNotFoundException, IOException {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print(PROMPT);
                Command command = CommandFactory.createCommand(scan.next().toLowerCase());
                List<String> argments = Arrays.asList(scan.nextLine().split(DELIMITER));
                command.setArgments(argments);
                if (validate(command)) {
                    continue;
                }
                if (execute(command)) {
                    break;
                }
            }
        }
    }

    private static boolean execute(Command command) {
        Result result = command.execute();
        outputMessages(result);
        return result != null && result.getCode() == Status.BREAK;
    }

    private static boolean validate(Command command) {
        Result result = command.validate();
        outputMessages(result);
        return result != null && result.getCode() == Status.CONTINUE;
    }

    private static void outputMessages(Result result) {
        if (result != null && result.getMesages().size() > 0) {
            result.getMesages().stream().forEach(message -> {
                System.out.println(message);
            });
        }
    }
}
