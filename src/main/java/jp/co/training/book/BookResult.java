package jp.co.training.book;

import java.util.EnumSet;
import java.util.Map;

import jp.co.training.ItemCode;
import jp.co.training.Result;

public class BookResult extends Result {

    private Book book;

    private Map<String, EnumSet<ItemCode>> itemCodes;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Map<String, EnumSet<ItemCode>> getItemCodes() {
        return itemCodes;
    }

    public void addCode(String key, ItemCode code) {
        if (itemCodes.get(key) == null) {
            itemCodes.put(key, EnumSet.noneOf(ItemCode.class));
        }
        itemCodes.get(key).add(code);
    }

}
