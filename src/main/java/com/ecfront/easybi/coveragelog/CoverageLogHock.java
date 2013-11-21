package com.ecfront.easybi.coveragelog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class CoverageLogHock {

      public Object around(ProceedingJoinPoint point) throws Throwable{
          if(point instanceof MethodInvocationProceedingJoinPoint){
              MethodInvocationProceedingJoinPoint methodPoint=  (MethodInvocationProceedingJoinPoint) point;
              methodPoint.getArgs();
          }
          System.out.println("begin around");
           Object object = point.proceed();
           System.out.println("end around");
           return object;
       }

}
