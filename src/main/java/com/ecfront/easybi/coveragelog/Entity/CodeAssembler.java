package com.ecfront.easybi.coveragelog.Entity;

import java.util.Arrays;

public class CodeAssembler {
    public static long packageCode(String packageName, String className, String methodName, String[] methodParameterTypes) {
        long result = packageName.hashCode();
        result = 31 * result + className.hashCode();
        result = 31 * result + methodName.hashCode();
        result = 31 * result + Arrays.hashCode(methodParameterTypes);
        return result;
    }
}