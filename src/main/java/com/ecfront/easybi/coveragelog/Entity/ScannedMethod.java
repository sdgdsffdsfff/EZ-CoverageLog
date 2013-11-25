package com.ecfront.easybi.coveragelog.Entity;

/**
 * 方法信息
 */
public class ScannedMethod {

    @PK
    private Long id;
    private Long code;
    //方法对应的包名
    private String packageName;
    //方法对应的类名
    private String className;
    //方法名
    private String methodName;
    //方法参数类型列表
    private String[] methodParameterTypes;

    public ScannedMethod() {
    }

    public ScannedMethod(String packageName, String className, String methodName, String[] methodParameterTypes) {
        this.id=System.nanoTime();
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.methodParameterTypes = methodParameterTypes;
        this.code = CodeAssembler.packageCode(packageName, className, methodName, methodParameterTypes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

}
