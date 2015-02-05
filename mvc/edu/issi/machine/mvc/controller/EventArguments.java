package edu.issi.machine.mvc.controller;

import edu.issi.machine.mvc.view.View;

/**
 * @author DawidSamolyk
 *
 */
public class EventArguments {
    private View caller;
    private String selectedElementName;

    /**
     * @param caller
     *            Widok, który wywo³a³ zdarzenie.
     */
    public EventArguments(View caller) {
	this.caller = caller;
    }

    /**
     * @param caller
     *            Widok, który wywo³a³ zdarzenie.
     * @param selectedElementName
     *            Nazwa elementu, którego dotyczy wydarzenie.
     */
    public EventArguments(View caller, String selectedElementName) {
	this(caller);
	this.selectedElementName = selectedElementName;
    }

    /**
     * @param view
     *            Widok.
     * @return Wskazuje czy widok jest tym, który wywo³a³ to zdarzenie.
     */
    public boolean isCalledBy(View view) {
	return view.equals(caller);
    }

    /**
     * @return Nazwa elementu, którego dotyczy zdarzenie.
     */
    public String getSelectedElementName() {
	return selectedElementName;
    }

    /**
     * @return Wskazuje czy posiada ustawion¹ nazwê elementu, którego dotyczy
     *         zdarzenie.
     */
    public boolean hasSelectedElementName() {
	return selectedElementName != null;
    }
}
