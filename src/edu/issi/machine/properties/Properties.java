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
     * @param value
     */
    public void add(Identity key, Object value) {
	properties.put(key, value);
    }
    
    /**
     * @param key
     */
    public void remove(Identity key) {
	properties.remove(key);
    }
    
    /**
     * @param key
     * @return Obiekt przypisany do podanego identyfikatora.
     * @throws NoSuchElementException 
     */
    public Object get(Identity key) throws NoSuchElementException {
	Object result = properties.get(key);
	
	if(result == null) {
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
