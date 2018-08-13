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
                Command command = CommandFactory.createCommand(scan.next());
                List<String> argments = Arrays.asList(scan.nextLine().split(DELIMITER));

                command.setArgments(argments);
                Result result = command.validate();
                if (result != null && result.getErrMesages().size() > 0) {
                    result.getErrMesages().stream().forEach(message -> {
                        System.err.println(message);
                    });
                }
                command.execute();
            }
        }
    }
}
