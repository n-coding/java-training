package jp.co.training;

import static jp.co.training.Const.*;

import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import jp.co.training.book.ItemCode;
import jp.co.training.command.CommandResult;
import jp.co.training.common.Code;
import jp.co.training.common.Status;

public class Viewer {

    private ResourceBundle rbMessages;

    // メッセージ定義ファイルのキー
    private static final String PROMPT_KEY = "prompt";
    private static final String END_MESSAGE_KEY = "end.message";

    //メッセージ定義ファイルのパス
    private static final String MESSAGES_RESOURCE = "messages";

    public Viewer() {
        try {
            rbMessages = ResourceBundle.getBundle(MESSAGES_RESOURCE);
        } catch (MissingResourceException e) {
            System.out.println("ERROR: cannnot find message file.");
            System.exit(1);
        }
    }

    public void promptMessages() {
        System.out.print(rbMessages.containsKey(PROMPT_KEY) ? rbMessages.getString(PROMPT_KEY) : "books>");
    }

    public void endMessages() {
        System.out.print(rbMessages.containsKey(END_MESSAGE_KEY) ? rbMessages.getString(PROMPT_KEY) : "bye.");
    }

    public void commandMessages(CommandResult commandResult) {
        if (commandResult.getStatus() == Status.OK) {
            standardMessages(commandResult.getCommandName());
        } else {
            errorMessages(commandResult.getCodes());
            errorMessages(commandResult.getItemCodes());
        }

    }

    public void standardMessages(String commandName) {
        switch (commandName) {
        case INSERT:
            System.out.println("inserted");
            break;
        default:
        }
    }

    public void errorMessages(Map<String, Set<ItemCode>> itemCodes) {
        for (Map.Entry<String, Set<ItemCode>> entry : itemCodes.entrySet()) {
            System.out.println(entry.getKey());
            for (ItemCode code : entry.getValue()) {
                System.out.println(code);
            }
        }
    }

    public void errorMessages(Set<Code> codes) {
        for (Code code : codes) {
            System.out.println(code);
        }
    }

}
