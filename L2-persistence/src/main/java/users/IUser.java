package users;

public interface IUser {

    public String toString();

    /**
     * @return the id
     */
    public int getId();

    /**
     * @param id the id to set
     */
    public void setId(int id);

    /**
     * @return the name
     */
    public String getName();

    /**
     * @param name the name to set
     */
    public void setName(String name);

    /*
    public Set<IEvent> getEvents();

    public void setEvents(Set<IEvent> events);
	*/
}