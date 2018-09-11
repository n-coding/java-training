package jp.co.training;

public enum Code {
    WRONG_NUMBER_OF_ARGUMENTS("E001"), INVALID_COMMAND("E002"), IO_ERROR("E003");

    private final String code;

    Code(String code) {
        this.code = code;
    }

}
