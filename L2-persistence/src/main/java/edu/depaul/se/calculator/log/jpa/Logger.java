package edu.depaul.se.calculator.log.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Logger {

    public void log(String message) {
        DBLogger log = new DBLogger();
        log.setMessage(message);
        EntityManager em = Persistence.createEntityManagerFactory("accountPU").createEntityManager();
        em.persist(log);
    }

}
