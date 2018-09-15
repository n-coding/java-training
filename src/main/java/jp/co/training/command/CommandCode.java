package jp.co.training.command;

import jp.co.training.common.Code;

public enum CommandCode implements Code {

    WRONG_NUMBER_OF_ARGUMENTS("E001"), INVALID_COMMAND("E002");

    private final String code;

    CommandCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
