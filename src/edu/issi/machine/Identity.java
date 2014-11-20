package edu.issi.machine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dawid
 * 
 */
public class Identity {
    private static final List<Identity> actualIdentities = new ArrayList<Identity>();
    private int id;
    /**
     * 
     */
    public static final Identity SAMPLE = new Identity(0);

    /**
     * @param id
     * @throws SecurityException 
     */
    public Identity(int id) throws SecurityException {
	this.id = id;

	if (actualIdentities.contains(this)) {
	    throw new SecurityException("Nie moga istniec dwa obiekty o tym samym numerze ID!");
	}

	actualIdentities.add(this);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
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
	return true;
    }

}
