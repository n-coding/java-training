package jp.co.training;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private StatusCode code = StatusCode.KEEP;
    private final List<String> mesages = new ArrayList<>();

    public List<String> getMesages() {
        return mesages;
    }

    public void addErrMessage(String msg) {
        mesages.add(msg);
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

}
