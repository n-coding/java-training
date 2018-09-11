package jp.co.training.book;

import static jp.co.training.ItemCode.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Pattern;

import jp.co.training.ItemCode;

public class BookValidater {

    private BookValidater() {
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
    public static Optional<ItemCode> checkLength(String target, int min, int max) {
        if (target == null || target.length() < min) {
            return Optional.of(MIN_LENGTH_UNDER);
        } else if (target.length() > max) {
            return Optional.of(MAX_LENGTH_OVER);
        }
        return Optional.empty();
    }

    public static Optional<ItemCode> checkDatePattern(String target, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(target, df);
        } catch (DateTimeParseException e) {
            return Optional.of(INVALID_DATE_PATTERN);
        }
        return Optional.empty();
    }

    public static Optional<ItemCode> checkNumber(String target) {
        if (!isNumber(target)) {
            return Optional.of(NOT_NUMERICAL);
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

}
