package jp.co.training;

import static jp.co.training.Const.*;
import static jp.co.training.Main.*;

import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import jp.co.training.book.ItemCode;
import jp.co.training.common.Code;

public class Viewer {

    private ResourceBundle rbMessages;

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
        System.out.print(config.prompt);
    }

    public void endMessages() {
        System.out.print(config.endMessage);
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
