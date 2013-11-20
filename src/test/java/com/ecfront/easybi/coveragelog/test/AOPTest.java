package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.easybi.coveragelog.repositories.AllMethodRepository;
import org.junit.Test;

import javax.inject.Inject;

public class AOPTest extends BaseTest {

    @Test
     public void testLoadAllMethod(){

     }

    @Inject
    private AllMethodRepository allMethodRepository;
}
