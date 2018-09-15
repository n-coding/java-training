package jp.co.training.book;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jp.co.training.common.Result;

public class BookResult extends Result {

    private Book book;

    private Map<String, Set<ItemCode>> itemCodes;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Map<String, Set<ItemCode>> getItemCodes() {
        return itemCodes;
    }

    public void addCode(String key, ItemCode code) {
        if (itemCodes.get(key) == null) {
            itemCodes.put(key, new HashSet<>());
        }
        itemCodes.get(key).add(code);
    }

}
