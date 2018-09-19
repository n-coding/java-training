package jp.co.training;

import static jp.co.training.Const.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import jp.co.training.command.Command;
import jp.co.training.command.CommandResult;
import jp.co.training.command.ExitCommand;
import jp.co.training.command.InsertCommand;

public final class Main {

    public static Config config;

    public static void main(String... args) throws FileNotFoundException, IOException {

        config = new Config().load(args.length > 0 && args[0] != null ? args[0] : CONFIG_FILE);
        Viewer viewer = new Viewer();

        Command command = new ExitCommand(EXIT);
        command.setNext(new InsertCommand(INSERT));

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                viewer.promptMessages();
                String inputCommand = scan.next().toLowerCase();
                String argments = scan.nextLine().trim();

                // コマンド実行
                CommandResult result = command.execute(inputCommand, argments);

                //実行結果を出力
                viewer.commandMessages(result);

                if (result != null && result.isExit()) {
                    break;
                }
            }
        }
        viewer.endMessages();
    }

}
