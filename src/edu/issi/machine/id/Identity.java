package edu.issi.machine.id;

import java.io.Serializable;

/**
 * @author Dawid
 * 
 */
public class Identity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1494708831585331100L;
    private int id;
    private String name;
    /**
     * 
     */
    public static final Identity SAMPLE = new Identity(0);

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @throws SecurityException
     *             Wyst¹pi, gdy nast¹pi próba stworzenia dwóch obiektów o tym
     *             samym numerze ID.
     */
    public Identity(int id) throws SecurityException {
	this.id = id;
	this.name = new Integer(id).toString();
    }

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa.
     * @throws SecurityException
     *             Wyst¹pi, gdy nast¹pi próba stworzenia dwóch obiektów o tym
     *             samym numerze ID.
     */
    public Identity(int id, String name) throws SecurityException {
	this.id = id;
	this.name = name;
    }

    @Override
    public String toString() {
	return "Identity [id=" + id + ", name=" + name + "]";
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
	if (getClass() != obj.getClass())
	    return false;
	Identity other = (Identity) obj;
	if (id != other.id)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

}
