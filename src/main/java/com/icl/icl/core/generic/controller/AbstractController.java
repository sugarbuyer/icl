package com.icl.icl.core.generic.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;

public class AbstractController implements ApplicationContextAware {
    protected ApplicationContext applicationContext;
    protected String urlBase;

    protected String retrieveUrlBase(){
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);

        return requestMapping.value()[0];
    }

    public AbstractController(){
        this.urlBase = retrieveUrlBase();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
