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

	public Config load(String path) {
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle(path);
		} catch (MissingResourceException e) {
			System.out.println("ERROR: cannnot find configfile.");
			System.exit(1);
		}
		if (!rb.containsKey(USER_NAME_KEY)) {
			System.out.println("ERROR: you must define registrant in configfile.");
			System.exit(1);
		}

		userName = rb.getString(USER_NAME_KEY);
		prompt = (rb.containsKey(PROMPT_KEY)) ? rb.getString(PROMPT_KEY) : "books>";
		delimiter = (rb.containsKey(DELIMITER_KEY)) ? rb.getString(DELIMITER_KEY) : ",";
		saveFile = (rb.containsKey(SAVE_FILE_KEY)) ? rb.getString(DELIMITER_KEY) : "savefile";
		endMessage = (rb.containsKey(END_MESSAGE_KEY)) ? rb.getString(END_MESSAGE_KEY) : "bye.";
		return this;
	}
}
