package jp.co.training.dao;

import java.util.HashSet;
import java.util.Set;

import jp.co.training.common.Code;
import jp.co.training.common.Result;

public class DaoResult extends Result {

    private Set<Code> codes = new HashSet<>();

    public Set<Code> getCodes() {
        return codes;
    }

    public void addCode(Code code) {
        codes.add(code);
    }

    public void addCodes(Set<Code> codes) {
        this.codes.addAll(codes);
    }

}
