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
	return id.hashCode();
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
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    /**
     * @param productID
     * @return Czy ten obiekt jest identyfikowany podanym ID.
     */
    public boolean identifiesBy(int productID) {
	return id.identifiesBy(productID);
    }

}
