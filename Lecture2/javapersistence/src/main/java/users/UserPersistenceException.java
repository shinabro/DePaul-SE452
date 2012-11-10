package users;

public class UserPersistenceException extends Exception {
    public UserPersistenceException(String errorMessage) {
        super(errorMessage);
    }

    public UserPersistenceException(Throwable throwable) {
        super(throwable);
    }
}
