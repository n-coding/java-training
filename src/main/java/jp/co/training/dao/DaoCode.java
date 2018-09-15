package jp.co.training.dao;

import jp.co.training.common.Code;

public enum DaoCode implements Code {

    IO_ERROR("E003");

    private final String code;

    DaoCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
