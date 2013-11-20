package com.ecfront.easybi.coveragelog.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {

    public void test1(){
        logger.debug("test1");
    }

    public void test2(){
        logger.debug("test2");
    }

    private static final Logger logger = LoggerFactory.getLogger(Example.class);
}
