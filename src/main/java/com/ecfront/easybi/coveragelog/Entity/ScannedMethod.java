package com.ecfront.easybi.coveragelog.Entity;

import java.util.Arrays;

public class ScannedMethod {
    private long code;

    private String packageName;
    private String className;
    private String methodName;
    private String[] methodParameterTypes;

    public ScannedMethod(String packageName, String className, String methodName, String[] methodParameterTypes) {
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.methodParameterTypes = methodParameterTypes;
        this.code = ScannedMethod.packageCode(packageName, className, methodName, methodParameterTypes);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getMethodParameterTypes() {
        return methodParameterTypes;
    }

    public void setMethodParameterTypes(String[] methodParameterTypes) {
        this.methodParameterTypes = methodParameterTypes;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public static long packageCode(String packageName, String className, String methodName, String[] methodParameterTypes) {
        long result = packageName.hashCode();
        result = 31 * result + className.hashCode();
        result = 31 * result + methodName.hashCode();
        result = 31 * result + Arrays.hashCode(methodParameterTypes);
        return result;
    }
}
