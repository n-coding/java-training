package jp.co.training;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Const {

    //外部ファイルによる設定不可能な定数
    public static final String INSERT = "insert";
    public static final String EXIT = "exit";
    public static final int MAX_ISBN = 13;
    public static final int MAX_BOOK_NAME = 50;
    public static final int MAX_AUTHOR = 30;
    public static final int MAX_PUBLISHER = 30;
    public static final int MAX_PRICE = 9;

    //外部ファイルによる設定が可能な定数
    public static final String PROMPT;
    public static final String DELIMITER;
    public static final String SAVE_FILE;

    //外部ファイルの設定ファイルのキー
    private static final String PROMPT_KEY = "prompt";
    private static final String DELIMITER_KEY = "delimiter";
    private static final String SAVE_FILE_KEY = "save.file";

    static {
        ResourceBundle rb = loadResource();
        PROMPT = (rb == null || !rb.containsKey(PROMPT_KEY)) ? "books>" : rb.getString(PROMPT_KEY);
        DELIMITER = (rb == null || !rb.containsKey(DELIMITER_KEY)) ? "," : rb.getString(DELIMITER_KEY);
        SAVE_FILE = (rb == null || !rb.containsKey(SAVE_FILE_KEY)) ? "savefile" : rb.getString(SAVE_FILE_KEY);
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
