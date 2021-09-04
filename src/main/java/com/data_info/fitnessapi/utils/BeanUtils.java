package com.data_info.fitnessapi.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.context=applicationContext;
    }

    public static <T> T getBean(Class<T> clazz){
        return BeanUtils.context.getBean(clazz);
    }
}
