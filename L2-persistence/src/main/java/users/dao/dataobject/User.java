package users.dao.dataobject;

//import users.IEvent;
import users.IUser;

//import java.util.Set;

public class User implements IUser {
    private int id;
    private String name;

    /* (non-Javadoc)
	 * @see users.IUser#toString()
	 */
    @Override
    public String toString() {
        return "users.User[id=" + id + ",name=" + name + "]";
    }

    /* (non-Javadoc)
	 * @see users.IUser#getId()
	 */
    public int getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see users.IUser#setId(int)
	 */
    public void setId(int id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see users.IUser#getName()
	 */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see users.IUser#setName(java.lang.String)
	 */
    public void setName(String name) {
        this.name = name;
    }

    /*
    private Set<IEvent> events;

    public Set<IEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<IEvent> events) {
        this.events = events;
    }
    */
}
