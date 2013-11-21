package com.ecfront.easybi.coveragelog;

import com.ecfront.easybi.coveragelog.Entity.CoverageLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.lang.reflect.Method;

public class CoverageLogHock {

    public Object around(ProceedingJoinPoint point) throws Throwable {
        CoverageLog coverageLog = parseActive(point);
        Object object = point.proceed();
        coverageLog.setFinishTime(System.nanoTime());
        return object;
    }

    private CoverageLog parseActive(ProceedingJoinPoint point) {
        Class<?> clazz = point.getTarget().getClass();
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        return new CoverageLog(clazz.getPackage().getName(), clazz.getSimpleName(), method.getName(), MethodScanner.getMethodParameterTypes(method), System.nanoTime());
    }

}
