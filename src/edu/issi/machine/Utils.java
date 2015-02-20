package edu.issi.machine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.issi.machine.id.ObjectWithIdentity;

public class Utils {

    public static <T extends ObjectWithIdentity> Map<String, T> asMap(Collection<T> objects) {
	Map<String, T> result = new HashMap<String, T>(objects.size());
	
	for(T each : objects) {
	    result.put(each.getName(), each);
	}
	
	return result;
    }

}
