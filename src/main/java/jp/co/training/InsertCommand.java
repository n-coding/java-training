package jp.co.training;

import static jp.co.training.Const.DATE_TIME_PATTERN;
import static jp.co.training.Const.DELIMITER;
import static jp.co.training.Const.ID_LENGTH;
import static jp.co.training.Const.SAVE_FILE;
import static jp.co.training.Const.USER_NAME;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class InsertCommand extends Command {

	private Result result;

	private Book book;

	public InsertCommand(String name) {
		super(name);
	}

	@Override
	public Result executeCommand(String command, String[] argments) {
		result = new Result();
		if (!validate(argments)) {
			return result;
		}
		return createBook();
	}

	private Result createBook() {

		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

		String output = String.join(BookUtil.generateID(ID_LENGTH),
				book.toString(),
				USER_NAME, today,
				USER_NAME, today,
				DELIMITER);

		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(SAVE_FILE, true), StandardCharsets.UTF_8))) {
			bw.write(output);
			bw.newLine();
		} catch (IOException ex) {
			result.addMessage(SAVE_FILE + ": cannot open.");
			result.setExit(true);
			return result;
		}
		result.addMessage("inserted.");
		return result;
	}

	/*
	 * 検証の結果OKならtrueを返す。それ以外はfalseを返す
	 */
	private boolean validate(String[] argments) {
		// パラメータ数チェック
		if (argments.length != 6) {
			result.addMessage("SyntaxError. The number of arguments does not match.");
			return false;
		}

		// 書籍情報のチェック
		book = new Book.Builder()
				.isbn(argments[0])
				.bookName(argments[1])
				.author(argments[2])
				.publisher(argments[3])
				.publicationDate(argments[4])
				.price(argments[5]).build();
		result.getMesages().addAll(book.validate().getMesages());
		return result.getMesages().isEmpty();
	}

}
