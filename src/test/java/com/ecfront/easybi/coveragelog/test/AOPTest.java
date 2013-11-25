package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AOPTest extends BaseTest {

    @Test
    public void testVisit() throws Exception {
        example.test2();
    }

    @Autowired
    private Example example;
}