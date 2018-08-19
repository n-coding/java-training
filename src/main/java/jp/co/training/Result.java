package jp.co.training;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private Status code = Status.KEEP;
    private final List<String> mesages = new ArrayList<>();

    public List<String> getMesages() {
        return mesages;
    }

    public void addErrMessage(String msg) {
        mesages.add(msg);
    }

    public Status getCode() {
        return code;
    }

    public void setCode(Status code) {
        this.code = code;
    }

}
