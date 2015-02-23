package edu.issi.machine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.issi.machine.id.ObjectWithIdentity;

/**
 * @author Dawid
 * 
 *         Dodatkowe narzêdzia wspomaj¹ce.
 */
public class Utils {

    /**
     * Przekszta³cenie kolekcji w mapê, gdzie kluczem bêdzie nazwa obiektu.
     * 
     * @param objects
     *            Zbiór obiektów, który ma zostaæ przekszta³cony na mapê.
     * @return Mapa stworzona na podstawie wejœciowego zbioru. Kluczem
     *         jest nazwa obiektu.
     */
    public static <T extends ObjectWithIdentity> Map<String, T> asMap(Collection<T> objects) {
	Map<String, T> result = new HashMap<String, T>(objects.size());

	for (T each : objects) {
	    result.put(each.getName(), each);
	}

	return result;
    }

}
