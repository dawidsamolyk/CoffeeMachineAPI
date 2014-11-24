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
     *            Warto�� obiektu.
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
     *             Wyst�pi, je�li nie ma we w�a�ciwo�ciach obiektu o podanym ID.
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
}
