package edu.depaul.se.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Track context for servlet container life cycle
 */
@WebListener
public class MyContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("MyContextListener.... initialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("MyContextListener.... destroyed");
    }

}
