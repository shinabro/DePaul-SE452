package users.dao;

import users.IUser;
import users.IUserDAO;
import users.UserPersistenceException;
import users.dao.jpaobject.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPADAO implements IUserDAO {

    public List<IUser> getUsers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();
        Query userQuery = em.createQuery("SELECT u FROM User u");
        return userQuery.getResultList();
    }

    public List<IUser> getUsers(String userName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();
        Query userNameQuery = em.createNamedQuery("Users.findByName", User.class);
        userNameQuery.setParameter("name", userName);
        return userNameQuery.getResultList();
    }

    public int saveUser(IUser usr) {
        int retval = usr.getId();

        if (retval > 0) {
            updateUser(usr);
        } else {
            retval = createUser(usr);
        }
        return retval;
    }

    private void updateUser(IUser usr) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();
        Query userIdQuery = em.createNamedQuery("Users.findById", User.class);
        userIdQuery.setParameter("id", usr.getId());
        User user = (User) userIdQuery.getSingleResult();

        user.setName(usr.getName());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    private int createUser(IUser usr) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();

        User user = new User();
        user.setName(usr.getName());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return user.getId();
    }

    public void deleteUser(IUser usr) throws UserPersistenceException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();
        Query userIdQuery = em.createNamedQuery("Users.findById", User.class);
        userIdQuery.setParameter("id", usr.getId());
        User user = (User) userIdQuery.getSingleResult();

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

}
