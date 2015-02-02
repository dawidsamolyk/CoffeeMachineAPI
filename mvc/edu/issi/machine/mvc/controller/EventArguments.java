package edu.issi.machine.mvc.controller;

import edu.issi.machine.mvc.view.View;

/**
 * @author DawidSamolyk
 *
 */
public class EventArguments {
    private View caller;
    private String selectedElementName;

    public EventArguments(View caller) {
	this.caller = caller;
    }
    
    public EventArguments(View caller, String selectedElementName) {
	this(caller);
	this.selectedElementName = selectedElementName;
    }

    public boolean isCalledBy(View view) {
	return view.equals(caller);
    }
    
    public String getSelectedElementName() {
	return selectedElementName;
    }
    
    public boolean hasSelectedElementName() {
	return selectedElementName != null;
    }
}
