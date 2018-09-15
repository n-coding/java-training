package jp.co.training;

import static jp.co.training.Const.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import jp.co.training.validate.ItemValidater;

class BookUtilTest {

    @Nested
    class CheckLengthTest {
        @Test
        @DisplayName("最大文字超過チェックOK")
        void maxOverOK() {
            Optional<String> result = ItemValidater.checkLength("あいう", 1, 3);
            assertFalse(result.isPresent());
        }

        @Test
        @DisplayName("最小文字超過チェックOK")
        void minUnderOK() {
            Optional<String> result = ItemValidater.checkLength("あ", 1, 3);
            assertFalse(result.isPresent());
        }

        @Test
        @DisplayName("最大文字超過チェックNG")
        void maxOverNG() {
            Optional<String> result = ItemValidater.checkLength("あいうえ", 1, 3);
            assertEquals("the length must be " + 3 + " or less. but actual is " + 4 + ".", result.get());
        }

        @Test
        @DisplayName("最小文字超過チェックNG")
        void minUnderNG() {
            Optional<String> result = ItemValidater.checkLength("", 1, 3);
            assertEquals("the length must be " + 1 + " or more. but actual is " + 0 + ".", result.get());
        }

        @Test
        @DisplayName("nullチェックNG")
        void nullCheckNG() {
            Optional<String> result = ItemValidater.checkLength(null, 1, 3);
            assertEquals("the length must be " + 1 + " or more. but actual is null.", result.get());
        }
    }

    @Nested
    class checkDatePatternTest {
        @Test
        @DisplayName("有効な日付形式OK")
        void datePatternOK() {
            Optional<String> result = ItemValidater.checkDatePattern("20180815", DATE_PATTERN);
            assertFalse(result.isPresent());
        }

        @Test
        @DisplayName("無効な日付形式NG")
        void datePatternNG() {
            Optional<String> result = ItemValidater.checkDatePattern("20181815", DATE_PATTERN);
            assertEquals("Invalid Pattern. valid pattern is " + DATE_PATTERN + ".", result.get());
        }
    }
}
