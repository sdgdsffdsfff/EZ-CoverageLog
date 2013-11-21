package com.ecfront.easybi.utils.springext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertyHelper extends PropertyPlaceholderConfigurer {
    private static Map<String, String> properties;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,
                                     Properties props) throws BeansException {

        super.processProperties(beanFactory, props);
        properties = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            properties.put(keyStr, value);
        }
    }

    public static String get(String name) {
        return properties.get(name);
    }
}
