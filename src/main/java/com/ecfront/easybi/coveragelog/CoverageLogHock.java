package com.ecfront.easybi.coveragelog;

import com.ecfront.easybi.coveragelog.Entity.CodeAssembler;
import com.ecfront.easybi.coveragelog.Entity.CoverageLog;
import com.ecfront.easybi.coveragelog.repositories.CoverageLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

public class CoverageLogHock {

    public Object around(ProceedingJoinPoint point) throws Throwable {
        long enterTime=System.nanoTime();
        Object object = point.proceed();
         saveActive(point,enterTime);
        return object;
    }

    private void saveActive(ProceedingJoinPoint point, long enterTime) {
        Class<?> clazz = point.getTarget().getClass();
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        CoverageLog coverageLog=new CoverageLog(CodeAssembler.packageCode(clazz.getPackage().getName(), clazz.getSimpleName(), method.getName(), MethodScanner.getMethodParameterTypes(method)), enterTime,System.nanoTime());
        CoverageLogRepository.getInstance().save(coverageLog);
    }

}
