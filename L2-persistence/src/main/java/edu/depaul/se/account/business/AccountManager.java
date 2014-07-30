package edu.depaul.se.account.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.depaul.se.account.IAccount;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AccountManager implements Serializable {
    private static final Logger logger = Logger.getLogger(AccountManager.class.getName());

    /**
     * @return all the accounts we know about
     */
    public List<IAccount> getAccountList() {
        logger.info("Before getting connection");
        ArrayList<IAccount> list = new ArrayList<>();
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Before returning: {0}", list.size());
        }
        EntityManager em = Persistence.createEntityManagerFactory("accountPU").createEntityManager();
        return em.createNamedQuery("findAllAccounts").getResultList();
    }
}
