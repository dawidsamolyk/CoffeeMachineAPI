package edu.issi.machine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.issi.machine.id.ObjectWithIdentity;

/**
 * @author Dawid
 * 
 *         Dodatkowe narz�dzia wspomaj�ce.
 */
public class Utils {

    /**
     * Przekszta�cenie kolekcji w map�, gdzie kluczem b�dzie nazwa obiektu.
     * 
     * @param objects
     *            Zbi�r obiekt�w, kt�ry ma zosta� przekszta�cony na map�.
     * @return Mapa stworzona na podstawie wej�ciowego zbioru. Kluczem
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
