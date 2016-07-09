package com.spring.initandsestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Admin on 07.07.2016.
 */
public class MethodInitBean {
    private static final Logger logger=LoggerFactory.getLogger(MethodInitBean.class);

    public void someInit(){
        logger.debug("");
        logger.debug("Init method run...");
    }
    public void someDestroy(){
        logger.debug("");
        logger.debug("destroy method run..");
    }
}
