package jp.co.training;

import static jp.co.training.Main.*;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Pattern;

public class BookUtil {

    private BookUtil() {
    }

    /**
     * 対象文字列が指定された最小文字数と最大文字数の範囲内であるかをチェックします<br>
     * 範囲内である場合はOptionalの中身はnullとなる<br>
     * 範囲外である場合はOptionalの中身はエラーメッセージとなる<br>
     *
     * @param target
     * @param min
     * @param max
     * @return
     */
    public static Optional<String> checkLength(String target, int min, int max) {
        if (target == null || target.length() < min) {
            return Optional.of(config.getMessage(Code.MIN_LENGTH_UNDER, String.valueOf(min),
                    target == null ? "null" : String.valueOf(target.length())));
        } else if (target.length() > max) {
            return Optional.of(config.getMessage(Code.MAX_LENGTH_OVER, String.valueOf(max),
                    String.valueOf(target.length())));
        }
        return Optional.empty();
    }

    public static Optional<String> checkDatePattern(String target, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(target, df);
        } catch (DateTimeParseException e) {
            return Optional.of("Invalid Pattern. valid pattern is " + pattern + ".");
        }
        return Optional.empty();
    }

    public static Optional<String> checkNumber(String target) {
        if (!isNumber(target)) {
            return Optional.of("It is not a numerical format.");
        }
        return Optional.empty();
    }

    /**
     * valueが数値文字列の場合、または空文字の場合はtrueを返す
     *
     * @param value
     * @return
     */
    private static boolean isNumber(String value) {
        return Pattern.compile("^[0-9]*$").matcher(value).matches();
    }

    public static String generateID(int digit) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[digit / 2];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte d : bytes) {
            sb.append(String.format("%02X", d));
        }
        return sb.toString();
    }

}
