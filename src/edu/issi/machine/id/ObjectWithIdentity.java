package edu.issi.machine.id;

/**
 * @author Dawid
 *
 */
public class ObjectWithIdentity {
    private final Identity id;

    /**
     * @param id
     *            Numer ID.
     */
    public ObjectWithIdentity(final Identity id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return id.toString();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	final ObjectWithIdentity other = (ObjectWithIdentity) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	}
	else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public boolean identifiesBy(Identity identity) {
        return id.equals(identity);
    }

}
