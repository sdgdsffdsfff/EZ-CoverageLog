package com.ecfront.easybi.coveragelog.repositories;

public enum SortType {
    ASC(1), DESC(-1);

    private final int code;

    private SortType(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
