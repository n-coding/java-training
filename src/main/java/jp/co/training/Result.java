package jp.co.training;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private boolean exit = false;
    private final List<String> mesages = new ArrayList<>();

    public List<String> getMesages() {
        return mesages;
    }

    public void addMessage(String msg) {
        mesages.add(msg);
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

}
