package jp.co.training.dao;

import java.util.ArrayList;
import java.util.List;

public class SelectDaoResult<T> extends DaoResult {

    private List<T> records = new ArrayList<>();

    public List<T> getRecords() {
        return records;
    }

    public void add(T t) {
        records.add(t);
    }

}
