package jp.co.training;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private Status status = Status.NG;

    private final List<String> messages = new ArrayList<>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public void addMessages(List<String> messages) {
        this.messages.addAll(messages);
    }
}
