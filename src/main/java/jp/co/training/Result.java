package jp.co.training;

import java.util.EnumSet;

public class Result {

    private Status status = Status.NG;

    private EnumSet<Code> codes = EnumSet.noneOf(Code.class);

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public EnumSet<Code> getCodes() {
        return codes;
    }

    public void addCode(Code code) {
        codes.add(code);
    }

    public void addCodes(EnumSet<Code> codes) {
        this.codes.addAll(codes);
    }

}
