package com.ecfront.easybi.coveragelog.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AllMethod {
    @Indexed
    private String clazz;
    @Indexed
    private String method;

}
