package com.ecfront.easybi.coveragelog.Entity;


/**
 * 方法访问信息
 */
public class CoverageLog {

    @PK
    private Long id;
    //编码，每个方法的唯一编号
    private Long code;
    //进入方法的时间
    private Long enterTime;
    //完成方法的时间
    private Long finishTime;
    //方法使用（占用）时间
    private Long useTime;

    public CoverageLog() {
    }

    public CoverageLog(Long code, Long enterTime, Long finishTime) {
        this.id = System.nanoTime();
        this.code = code;
        this.enterTime = enterTime;
        this.finishTime = finishTime;
        this.useTime = finishTime - enterTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Long enterTime) {
        this.enterTime = enterTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }
}
