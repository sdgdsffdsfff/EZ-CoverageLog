package com.ecfront.easybi.coveragelog;

import com.ecfront.easybi.classscanner.exchange.ClassScanner;
import com.ecfront.easybi.coveragelog.Entity.ScannedMethod;
import com.ecfront.easybi.coveragelog.repositories.ScannedMethodRepository;
import com.ecfront.easybi.utils.PropertyHelper;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MethodScanner {

    public void scan() throws Exception {
        Set<Class<?>> classes = ClassScanner.scan(PropertyHelper.get("method.scan"));
        if (null != classes && classes.size() > 0) {
            List<ScannedMethod> scannedMethods = new ArrayList<ScannedMethod>();
            Method[] methods;
            for (Class<?> clazz : classes) {
                if (!clazz.isInterface()) {
                    methods = clazz.getDeclaredMethods();
                    for (Method method : methods) {
                        scannedMethods.add(new ScannedMethod(clazz.getPackage().getName(), clazz.getSimpleName(), method.getName(), getMethodParameterTypes(method)));
                    }
                }
            }
            scannedMethodRepository.save(scannedMethods);
        }
    }

    public static String[] getMethodParameterTypes(Method method) {
        Class<?>[] reflectParameterTypes = method.getParameterTypes();
        if (null != reflectParameterTypes && reflectParameterTypes.length > 0) {
            List<String> returnParameterTypes = new ArrayList<String>();
            for (Class<?> reflectParameterType : reflectParameterTypes) {
                returnParameterTypes.add(reflectParameterType.getName());
            }
            return returnParameterTypes.toArray(new String[returnParameterTypes.size()]);
        }
        return new String[]{};
    }

    @Inject
    private ScannedMethodRepository scannedMethodRepository;
}
