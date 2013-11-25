package com.ecfront.easybi.coveragelog.test;

import com.ecfront.easybi.coveragelog.Entity.ScannedMethod;
import com.ecfront.easybi.coveragelog.repositories.CoverageLogRepository;
import com.ecfront.easybi.coveragelog.repositories.ScannedMethodRepository;
import com.ecfront.easybi.coveragelog.repositories.SortType;
import com.ecfront.easybi.vo.PageVO;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MongoTest {

    @Before
    public void setup() {
        ScannedMethodRepository.getInstance().drop();
        CoverageLogRepository.getInstance().drop();
    }

    @Test
    public void test() {
        ScannedMethod scannedMethod = new ScannedMethod("com.ecfront", "Abc", "test", new String[]{"String", "int"});
        //test save
        ScannedMethodRepository.getInstance().save(scannedMethod);
        //test find
        PageVO<ScannedMethod> pageScannedMethods = ScannedMethodRepository.getInstance().find(new ScannedMethod() {{
            setClassName("aaa");
        }}, 0, 10);
        Assert.assertNull(pageScannedMethods);
        pageScannedMethods = ScannedMethodRepository.getInstance().find(new ScannedMethod() {{
            setClassName("Abc");
        }}, 0, 10);
        Assert.assertEquals(pageScannedMethods.results.size(), 1);
        //test get
        scannedMethod = ScannedMethodRepository.getInstance().get(pageScannedMethods.results.get(0).getId());
        Assert.assertEquals(scannedMethod.getMethodName(), "test");
        //test delete
        ScannedMethodRepository.getInstance().delete(pageScannedMethods.results.get(0).getId());
        //test save all
        List<ScannedMethod> scannedMethods = new ArrayList<ScannedMethod>();
        for (int i = 0; i < 20; i++) {
            scannedMethods.add(new ScannedMethod("com.ecfront", "Abc", i + "test", new String[]{"String", "int"}));
        }
        ScannedMethodRepository.getInstance().save(scannedMethods);
        //test paging
        pageScannedMethods = ScannedMethodRepository.getInstance().find(new ScannedMethod() {{
            setClassName("Abc");
        }}, 1, 2);
        Assert.assertEquals(pageScannedMethods.results.get(0).getMethodName(), "2test");
        //test sort
        pageScannedMethods = ScannedMethodRepository.getInstance().find(new ScannedMethod() {{
                                                                            setClassName("Abc");
                                                                        }}, 1, 2, new HashMap<String, SortType>() {{
                    put("methodName", SortType.DESC);
                }}
        );
        Assert.assertEquals(pageScannedMethods.results.get(0).getMethodName(), "7test");
    }
}
