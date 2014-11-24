package edu.issi.machine;

import java.util.Iterator;
import java.util.List;

/**
 * @author Dawid
 *
 * @param <Type>
 *            Typ obiekt�w, po kt�rych b�dziemy iterowa�.
 */
public class IteratorForMachineConfiguration<Type> implements Iterator<Type> {
    private Iterator<Type> iterator;

    /**
     * @param list
     *            �r�d�owa lista, dla kt�rej ma zosta� utworzony iterator.
     */
    public IteratorForMachineConfiguration(List<Type> list) {
	this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
	return iterator.hasNext();
    }

    @Override
    public Type next() {
	return iterator.next();
    }

    /**
     * @throws UnsupportedOperationException
     *             Wyst�pi zawsze, poniewa� nie dopuszczamy mo�liwo�ci zmiany
     *             konfiguracji maszyny w trakcie jej dzia�ania.
     */
    @Override
    public void remove() throws UnsupportedOperationException {
	throw new UnsupportedOperationException("Nie mo�na usuwa� podzespo��w!");
    }

}
