package edu.issi.machine.mvc.controller;

import java.util.Iterator;
import java.util.List;

/**
 * @author DawidSamolyk
 *
 */
public class EventArguments {
    private List<String> names;

    public EventArguments(List<String> names) throws IllegalArgumentException {
	this.names = names;
    }

    public Iterator<String> iterator() {
	return names.iterator();
    }
}
