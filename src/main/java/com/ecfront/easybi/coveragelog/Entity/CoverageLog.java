package com.ecfront.easybi.coveragelog.Entity;

public class CoverageLog {
    private long code;

    private long enterTime;
    private long finishTime;
    private long useTime;

    public CoverageLog(long code, long enterTime, long finishTime) {
        this.code = code;
        this.enterTime = enterTime;
        this.finishTime = finishTime;
        this.useTime = finishTime - enterTime;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(long enterTime) {
        this.enterTime = enterTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }
}
