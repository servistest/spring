package com.spring.initandsestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Admin on 07.07.2016.
 */
public class SpringInterfaceInitBean implements InitializingBean,DisposableBean {

    private static final Logger logger= LoggerFactory.getLogger(MethodInitBean.class);
    public void destroy() throws Exception {
        logger.debug("");
        logger.debug("Init method start");
    }

    public void afterPropertiesSet() throws Exception {
        logger.debug("");
        logger.debug("Destroy method stop");

    }
}
