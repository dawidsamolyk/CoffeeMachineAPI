package edu.issi.machine.id;

/**
 * @author Dawid
 * 
 */
public class Identity {
    private final int id;
    private String name;

    /**
     * @param id
     *            Numer identyfikacyjny.
     */
    public Identity(int id) {
	this.id = id;
	name = Integer.toString(id);
    }

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa.
     */
    public Identity(int id, String name) {
	this(id);
	this.name = name;
    }

    /**
     * @param newName
     *            Nowa nazwa.
     * @return Poprzednia nazwa.
     */
    public String changeName(String newName) {
	String actualName = name;

	name = newName;

	return actualName;
    }

    /**
     * @return Nazwa.
     */
    public String getName() {
	return name;
    }

    @Override
    public String toString() {
	return "ID: " + id + ", Nazwa: " + name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!getClass().equals(obj.getClass()))
	    return false;
	final Identity other = (Identity) obj;
	if (id != other.id)
	    return false;
	return true;
    }

}
