package com.spring.initandsestroy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.initandsestroy.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Admin on 06.07.2016.
 */
public class Instantion1 {

    private static final Logger log= LoggerFactory.getLogger(Instantion1.class);
    private static final Gson gson= new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        Person person=context.getBean("person-default-constructor",Person.class);
        person=context.getBean("person-specific-constructor",Person.class);
        log.debug("Default constructor: {}",gson.toJson(person));

        person=context.getBean("person-factory-method",Person.class);
        log.debug("Default constructor with arg: {}",gson.toJson(person));

        person=context.getBean("person-factory-method-with-parameters",Person.class);
        log.debug("Default constructor with factory mehod : {}",gson.toJson(person));

        for (int i = 0; i < 5; i++) {
            //Thread.sleep(1000);
            Date currentDate = context.getBean("currentDate", Date.class);
            log.debug("Date: {} ,HashCode: {} ",gson.toJson(currentDate),currentDate.hashCode());
        }
        Thread.sleep(5000);
        Date notLazy=context.getBean("dateNotLazy",Date.class);
        Date lazy=context.getBean("dateLazy",Date.class);

        log.debug("notLazy: {}",notLazy);
        log.debug("Lazy: {}",lazy);


    }
}
