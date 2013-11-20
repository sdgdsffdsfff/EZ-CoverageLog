package com.ecfront.easybi.coveragelog;

import org.aspectj.lang.ProceedingJoinPoint;

public class BaseCoverageLog {

      public Object around(ProceedingJoinPoint point) throws Throwable{
          System.out.println("begin around");
           Object object = point.proceed();
           System.out.println("end around");
           return object;
       }

}
