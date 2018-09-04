package jp.co.training;

import static jp.co.training.Const.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public final class Main {

    public static Config config;

    public static void main(String... args) throws FileNotFoundException, IOException {

        config = new Config().load(args.length > 0 && args[0] != null ? args[0] : CONFIG_FILE);

        Command command = new InsertCommand(INSERT);
        command.setNext(new ExitCommand(EXIT));

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print(config.prompt);
                String inputCommand = scan.next().toLowerCase();
                String[] argments = scan.nextLine().split(config.delimiter);
                argments = (String[]) Arrays.stream(argments).map(e -> e.trim()).toArray(String[]::new);

                // コマンド実行
                CommandResult result = command.execute(inputCommand, argments);
                outputMessages(result);
                if (result != null && result.isExit()) {
                    break;
                }
            }
        }
    }

    private static void outputMessages(CommandResult result) {
        if (result != null && result.getMessages().size() > 0) {
            result.getMessages().stream().forEach(message -> {
                System.out.println(message);
            });
        }
    }
}
