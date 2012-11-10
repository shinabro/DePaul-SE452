package users.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import users.IUser;
import users.IUserDAO;
import users.UserPersistenceException;
import users.dao.dataobject.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateDAO implements IUserDAO {

    private Session session;

    public HibernateDAO() {

    }

    public List<IUser> getUsers() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(User.class);
        List<IUser> result = crit.list();

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<IUser> getUsers(String userName) {
        List<IUser> result = new ArrayList<IUser>();
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        String SQL_QUERY = " from User as user where user.name='" + userName + "'";
        Query query = session.createQuery(SQL_QUERY);
        for (Iterator<IUser> it = query.iterate(); it.hasNext(); ) {
            result.add(it.next());
        }
        session.close();
        return result;
    }

    public int saveUser(IUser user) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);

        session.getTransaction().commit();
        session.close();
        return user.getId();
    }

    public void deleteUser(IUser user) throws UserPersistenceException {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Object userReference = session.load(User.class, user.getId());
        session.beginTransaction();
        session.delete(userReference);
        session.getTransaction().commit();
        session.close();
    }

}
