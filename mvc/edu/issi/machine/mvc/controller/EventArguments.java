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
     *            Widok, kt�ry wywo�a� zdarzenie.
     */
    public EventArguments(View caller) {
	this.caller = caller;
    }

    /**
     * @param caller
     *            Widok, kt�ry wywo�a� zdarzenie.
     * @param selectedElementName
     *            Nazwa elementu, kt�rego dotyczy wydarzenie.
     */
    public EventArguments(View caller, String selectedElementName) {
	this(caller);
	this.selectedElementName = selectedElementName;
    }

    /**
     * @param view
     *            Widok.
     * @return Wskazuje czy widok jest tym, kt�ry wywo�a� to zdarzenie.
     */
    public boolean isCalledBy(View view) {
	return view.equals(caller);
    }

    /**
     * @return Nazwa elementu, kt�rego dotyczy zdarzenie.
     */
    public String getSelectedElementName() {
	return selectedElementName;
    }

    /**
     * @return Wskazuje czy posiada ustawion� nazw� elementu, kt�rego dotyczy
     *         zdarzenie.
     */
    public boolean hasSelectedElementName() {
	return selectedElementName != null;
    }
}
