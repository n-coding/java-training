package jp.co.training;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Const {

	// 外部ファイルによる設定不可能な定数
	public static final String INSERT = "insert";
	public static final String EXIT = "exit";
	public static final int MAX_ISBN = 13;
	public static final int MAX_BOOK_NAME = 50;
	public static final int MAX_AUTHOR = 30;
	public static final int MAX_PUBLISHER = 30;
	public static final int MAX_PRICE = 9;
	public static final String DATE_PATTERN = "yyyyMMdd";
	public static final String DATE_TIME_PATTERN = "yyyyMMdd hhmmss.SSS";
	public static final int ID_LENGTH = 16;

	// 外部ファイルによる設定が可能な定数
	public static final String PROMPT;
	public static final String END_MESSAGE;
	public static final String DELIMITER;
	public static final String SAVE_FILE;
	public static final String USER_NAME;

	// 外部ファイルの設定ファイルのキー
	private static final String PROMPT_KEY = "prompt";
	private static final String END_MESSAGE_KEY = "end.message";
	private static final String DELIMITER_KEY = "delimiter";
	private static final String SAVE_FILE_KEY = "save.file";
	private static final String USER_NAME_KEY = "user.name";

	static {
		ResourceBundle rb = loadResource();
		if (rb == null) {
			System.out.println("cannnot find configfile.");
			System.exit(1);
		}
		if (!rb.containsKey(USER_NAME_KEY)) {
			System.out.println("you must define registrant in configfile.");
			System.exit(1);
		}
		USER_NAME = rb.getString(USER_NAME_KEY);
		PROMPT = (rb.containsKey(PROMPT_KEY)) ? rb.getString(PROMPT_KEY) : "books>";
		DELIMITER = (rb.containsKey(DELIMITER_KEY)) ? rb.getString(DELIMITER_KEY) : ",";
		SAVE_FILE = (rb.containsKey(SAVE_FILE_KEY)) ? rb.getString(DELIMITER_KEY) : "savefile";
		END_MESSAGE = (rb.containsKey(END_MESSAGE_KEY)) ? rb.getString(END_MESSAGE_KEY) : "bye.";
	}

	private static ResourceBundle loadResource() {
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle("resource");
		} catch (MissingResourceException e) {
			System.out.println("WARNNING: cannot find resource.properties");
		}
		return rb;
	}
}
