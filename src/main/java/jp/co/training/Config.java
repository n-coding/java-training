package jp.co.training;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Config {

    // 外部ファイルによる設定が可能な定数
    public String prompt;
    public String endMessage;
    public String delimiter;
    public String saveFile;
    public String userName;

    // 外部ファイルの設定ファイルのキー
    private static final String PROMPT_KEY = "prompt";
    private static final String END_MESSAGE_KEY = "end.message";
    private static final String DELIMITER_KEY = "delimiter";
    private static final String SAVE_FILE_KEY = "save.file";
    private static final String USER_NAME_KEY = "user.name";

    ResourceBundle rbMessages;

    //メッセージ定義ファイルのパス
    private static final String MESSAGES_RESOURCE = "messages";

    public Config load(String path) {
        ResourceBundle rbProperties = null;
        try {
            rbProperties = ResourceBundle.getBundle(path);
        } catch (MissingResourceException e) {
            System.out.println("ERROR: cannnot find configfile.");
            System.exit(1);
        }
        if (!rbProperties.containsKey(USER_NAME_KEY)) {
            System.out.println("ERROR: you must define registrant in configfile.");
            System.exit(1);
        }

        try {
            rbMessages = ResourceBundle.getBundle(MESSAGES_RESOURCE);
        } catch (MissingResourceException e) {
            System.out.println("ERROR: cannnot find message file.");
            System.exit(1);
        }

        userName = rbProperties.getString(USER_NAME_KEY);
        prompt = (rbProperties.containsKey(PROMPT_KEY)) ? rbProperties.getString(PROMPT_KEY) : "books>";
        delimiter = (rbProperties.containsKey(DELIMITER_KEY)) ? rbProperties.getString(DELIMITER_KEY) : ",";
        saveFile = (rbProperties.containsKey(SAVE_FILE_KEY)) ? rbProperties.getString(DELIMITER_KEY) : "savefile";
        endMessage = (rbProperties.containsKey(END_MESSAGE_KEY)) ? rbProperties.getString(END_MESSAGE_KEY) : "bye.";
        return this;
    }

    public String getMessage(ItemCode code, String... params) {

        // メッセージ取得
        String msg = rbMessages.getString(code.getCode());

        // 可変項目の置換え
        for (int i = 0; i < params.length; i++) {
            msg.replaceFirst("{" + i + "}", params[i]);
        }
        return msg;
    }
}
