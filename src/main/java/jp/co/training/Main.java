package jp.co.training;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import static jp.co.training.Const.DELIMITER;
import static jp.co.training.Const.PROMPT;

public final class Main {

    public static void main(String... args) throws FileNotFoundException, IOException {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print(PROMPT);
                Command command = CommandFactory.createCommand(scan.next().toLowerCase());
                command.setArgments(scan.nextLine().split(DELIMITER));

                Result result = command.execute();
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
