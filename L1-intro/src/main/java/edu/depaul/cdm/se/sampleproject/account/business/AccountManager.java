package edu.depaul.cdm.se.sampleproject.account.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.depaul.cdm.se.sampleproject.account.IAccount;

public class AccountManager implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1118467706141443769L;

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

        return list;
    }
}
