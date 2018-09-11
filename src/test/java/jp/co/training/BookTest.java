package jp.co.training;

import static jp.co.training.Const.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import jp.co.training.book.Book;
import jp.co.training.command.CommandResult;

class BookTest {

    @Nested
    @DisplayName("validateメソッドのテスト")
    class validateTest {

        @Test
        @DisplayName("ISBNの文字数チェックエラー")
        void validateIsbnNG() {
            Book book = new Book.Builder().isbn("12345678901234")
                    .bookName("社長も投票で決める会社をやってみた")
                    .author("武井　浩三")
                    .publisher("WAVE出版")
                    .publicationDate("20180423")
                    .price("1620").build();
            CommandResult result = book.validate();
            assertFalse(result.isExit());
            assertEquals(1, result.getMesages().size());
            assertEquals("ISBM:the length must be " + MAX_ISBN + " or less. but actual is 14.",
                    result.getMesages().get(0));
        }

    }

    @Nested
    @DisplayName("toStringメソッドのテスト")
    class toStringTest {

    }

    @Nested
    @DisplayName("Builderクラスのテスト")
    class BuilderTest {

        @Nested
        @DisplayName("Buildメソッドのテスト")
        class buildTest {

        }

    }

}
