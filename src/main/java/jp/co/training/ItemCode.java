package jp.co.training;

public enum ItemCode {

    MAX_LENGTH_OVER("E101"), MIN_LENGTH_UNDER("E102"),

    INVALID_DATE_PATTERN("E103"), NOT_NUMERICAL("E104");

    private final String code;

    ItemCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
