package jp.co.training.common;

public abstract class Result {

    private Status status = Status.NG;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
