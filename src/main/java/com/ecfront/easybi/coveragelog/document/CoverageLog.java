package com.ecfront.easybi.coveragelog.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class CoverageLog {
    @Indexed
    private String clazz;
    @Indexed
    private String method;
    @Indexed
    private long enterTime;
    @Indexed
    private long finishTime;
    @Indexed
    private long useTime;

}
