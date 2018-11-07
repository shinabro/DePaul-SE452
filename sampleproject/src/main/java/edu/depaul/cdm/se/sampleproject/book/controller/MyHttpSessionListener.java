package edu.depaul.cdm.se.sampleproject.book.controller;

import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyHttpSessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed");

    }
}