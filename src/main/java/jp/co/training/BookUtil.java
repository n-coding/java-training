package jp.co.training;

import java.util.Optional;

public class BookUtil {

    private BookUtil() {
    }

    /**
     * 対象文字列が指定された最小文字数と最大文字数の範囲内であるかをチェックします<br>
     * 範囲内である場合はOptionalの中身はnullとなる<br>
     * 範囲外である場合はOptionalの中身は範囲外であることを示すメッセージとなる<br>
     *
     * @param target :
     * @param min
     * @param max
     * @param targetName
     * @return
     */
    public static Optional<String> checkRange(String target, int min, int max, String targetName) {
        if (target.length() < min) {
            return Optional.of(targetName + "of size: min is " + min + ". but your input is " + target.length() + ".");
        } else if (target.length() > max) {
            return Optional.of(targetName + "of size: max is " + max + ". but your input is " + target.length() + ".");
        }
        return Optional.empty();
    }
}
