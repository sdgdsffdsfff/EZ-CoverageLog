package com.ecfront.easybi.coveragelog.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScannedMethod {
    @Indexed
    private String packageName;
    @Indexed
    private String className;
    @Indexed
    private String methodName;
    @Indexed
    private String[] methodParameterTypes;

    public ScannedMethod() {
    }

    public ScannedMethod(String packageName, String className, String methodName, String[] methodParameterTypes) {
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.methodParameterTypes = methodParameterTypes;
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
}
