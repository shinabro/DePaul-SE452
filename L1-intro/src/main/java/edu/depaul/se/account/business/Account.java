package edu.depaul.se.account.business;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.depaul.se.account.IAccount;

public class Account implements Serializable {

    private static final Logger logger = Logger.getLogger(Account.class.getName());

    /**
     * 
     * @return all the accounts we know about
     * @throws SQLException 
     */
    public List<IAccount> getAccountList() throws SQLException {
        logger.info("Before getting connection");
        ArrayList<IAccount> list = new ArrayList<>();
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Before returning: {0}", list.size());
        }

        return list;
    }
}
