package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.easybi.coveragelog.repositories.CoverageLogRepository;
import com.ecfront.easybi.coveragelog.repositories.ScannedMethodRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AOPTest extends BaseTest {

    @Before
    public void setup(){
        CoverageLogRepository.getInstance().drop();
        example.test2();
        example.test1();
    }

    @Test
    public void testVisit() throws Exception {
        Assert.assertEquals(ScannedMethodRepository.getInstance().find(null,0,1).results.size(),1);
        Assert.assertEquals(CoverageLogRepository.getInstance().find(null,0,10).results.size(),2);
    }

    @Autowired
    private Example example;
}