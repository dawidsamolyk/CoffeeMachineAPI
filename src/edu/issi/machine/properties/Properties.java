package edu.issi.machine.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import edu.issi.machine.Identity;

/**
 * @author Dawid
 *
 */
public class Properties {
    private HashMap<Identity, Object> properties;

    /**
     * 
     */
    public Properties() {
	properties = new HashMap<Identity, Object>();
    }

    /**
     * @param key
     *            Numer ID obiektu.
     * @param value
     *            Wartoœæ obiektu.
     */
    public void add(Identity key, Object value) {
	properties.put(key, value);
    }

    /**
     * @param key
     *            Numer ID obiektu
     */
    public void remove(Identity key) {
	properties.remove(key);
    }

    /**
     * @param key
     *            Numer ID obiektu
     * @return Obiekt przypisany do podanego identyfikatora.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli nie ma we w³aœciwoœciach obiektu o podanym ID.
     */
    public Object get(Identity key) throws NoSuchElementException {
	Object result = properties.get(key);

	if (result == null) {
	    throw new NoSuchElementException("Nie ma obiektu o podanym identyfikatorze!");
	}

	return result;
    }

    /**
     * @return Iterator po wszystkich wlasciwosciach.
     */
    public Iterator<Entry<Identity, Object>> iterator() {
	return properties.entrySet().iterator();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((properties == null) ? 0 : properties.hashCode());
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
	Properties other = (Properties) obj;
	if (properties == null) {
	    if (other.properties != null)
		return false;
	} else if (!properties.equals(other.properties))
	    return false;
	return true;
    }

}
