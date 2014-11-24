package edu.issi.machine;

import java.util.Iterator;
import java.util.List;

/**
 * @author Dawid
 *
 * @param <Type>
 *            Typ obiektÛw, po ktÛrych bÍdziemy iterowaÊ.
 */
public class IteratorForMachineConfiguration<Type> implements Iterator<Type> {
    private Iterator<Type> iterator;

    /**
     * @param list
     *            èrÛd≥owa lista, dla ktÛrej ma zostaÊ utworzony iterator.
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
     *             Wystπpi zawsze, poniewaø nie dopuszczamy moøliwoúci zmiany
     *             konfiguracji maszyny w trakcie jej dzia≥ania.
     */
    @Override
    public void remove() throws UnsupportedOperationException {
	throw new UnsupportedOperationException("Nie moøna usuwaÊ podzespo≥Ûw!");
    }

}
