package edu.issi.machine;

/**
 * @author Dawid
 *
 */
public class ObjectWithId {
    private Identity id;

    /**
     * @param id
     *            Numer ID.
     */
    public ObjectWithId(final Identity id) {
	this.id = id;
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
	if (getClass() != obj.getClass())
	    return false;
	ObjectWithId other = (ObjectWithId) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
