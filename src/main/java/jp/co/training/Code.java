package jp.co.training;

public enum Code {

    MAX_LENGTH_OVER("E001"), MIN_LENGTH_UNDER("E002"), INVALID_DATE_PATTERN("E003"), NOT_NUMERICAL("E004");

    private final String code;

    Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
