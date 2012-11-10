package users;

import java.util.List;

public interface IUserDAO {
    /**
     * @return all the users
     */
    public List<IUser> getUsers() throws UserPersistenceException;

    /**
     * Find all the users with a particular user name
     *
     * @param userName
     * @return list of users matching the criteria
     */
    public List<IUser> getUsers(String userName) throws UserPersistenceException;

    /**
     * Save user data.  If user id exist then will update.  If user id is blank then it
     * will create a new user
     *
     * @param user - user information to save
     * @return user id
     */
    public int saveUser(IUser user) throws UserPersistenceException;

    /**
     * Extra challenge for those who would want to take on the work would be to add this method
     * along with the appropriate test (there should be at least 2)
     *
     * @param user
     * @throws UserPersistenceException
     */
    public void deleteUser(IUser user) throws UserPersistenceException;
}
