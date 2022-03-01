package com.icl.icl.core.generic.appContext;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class AppContextUtil {
    public static <T> T getBeanByType(ApplicationContext context, Class<T> clazz){
        Map<String, T> beanMap = context.getBeansOfType(clazz);

        int size = beanMap.size();

        if(size == 0){
            if(context.getParent() != null){
                return getBeanByType(context.getParent(), clazz);
            }

            throw new NoSuchBeanDefinitionException(clazz.getSimpleName());
        }

        if(size > 1){
            throw new NoSuchBeanDefinitionException(clazz.getSimpleName() + "의 Static bean 설정이 정의 되지 않음..");
        }

        return (T) beanMap.values().iterator().next();
    }
}
