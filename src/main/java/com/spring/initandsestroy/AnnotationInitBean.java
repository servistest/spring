package com.spring.initandsestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Admin on 07.07.2016.
 */
public class AnnotationInitBean {
    private static final Logger log= LoggerFactory.getLogger(AnnotationInitBean.class);

    @PostConstruct
    public void annotationInitMethod(){
        log.debug("");
        log.debug("Annotation init method start");
    }
    @PreDestroy
    public void annotationDestroyMethod(){
        log.debug("");
        log.debug("Annotation destroy method start");
    }
}
