package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.easybi.coveragelog.MethodScanner;
import org.junit.Test;

public class AOPTest extends BaseTest {

    @Test
    public void testScannedMethods() throws Exception {
        MethodScanner.getInstance().scan();
    }

    @Test
    public void testVisit() throws Exception {
        new Example().test1();
    }

}
