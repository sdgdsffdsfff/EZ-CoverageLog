package com.ecfront.easybi.vo;

import java.util.List;

public class PageVO<E> {
    public long pageNumber;
    public long pageSize;
    public long pageTotal;
    public List<E> results;

    public PageVO(long pageNumber, long pageSize, long pageTotal, List<E> results) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.results = results;
    }
}
