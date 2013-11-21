package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.easybi.coveragelog.MethodScanner;
import com.ecfront.easybi.coveragelog.repositories.ScannedMethodRepository;
import org.junit.Test;

import javax.inject.Inject;

public class AOPTest extends BaseTest {

    @Test
    public void testScannedMethods() throws Exception {
        methodScanner.scan();
    }

    @Test
    public void testVisit() throws Exception {
        new Example().test1();
        example.test2();
    }

    @Inject
    private Example example;
    @Inject
    private MethodScanner methodScanner;
}
