package com.spring.initandsestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Admin on 07.07.2016.
 */
public class InitDestroyExample {
    private static final Logger logger= LoggerFactory.getLogger(InitDestroyExample.class);

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[] {"springContext.xml"});
        Thread.sleep(3000);
        logger.info("Start destroy context");
        context.destroy();
    }
}
