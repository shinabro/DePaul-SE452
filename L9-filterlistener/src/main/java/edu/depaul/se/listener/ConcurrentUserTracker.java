package edu.depaul.se.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Track concurrent users using session
 */
@WebListener
public class ConcurrentUserTracker implements HttpSessionListener {

    private static int concurrentUsers = 0;

    public void sessionCreated(HttpSessionEvent se) {
        ++concurrentUsers;
    	System.out.println("Num of concurrentUsers after creation: " + concurrentUsers);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        --concurrentUsers;
    	System.out.println("Num of concurrentUsers after destory: " + concurrentUsers);    	
    	    	
    }

    public static int getConcurrentUsers() {
        return concurrentUsers;
    }
}
