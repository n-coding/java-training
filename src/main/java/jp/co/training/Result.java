package jp.co.training;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> errMesages = new ArrayList<>();

    public List<String> getErrMesages() {
        return errMesages;
    }

    public void addErrMessage(String msg) {
        errMesages.add(msg);
    }
}
