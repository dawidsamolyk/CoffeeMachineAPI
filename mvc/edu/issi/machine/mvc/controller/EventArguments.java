package edu.issi.machine.mvc.controller;

import edu.issi.machine.Validator;
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
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nie zostanie podany widok, kt�ry wywo�a�
     *             zdarzenie.
     */
    public EventArguments(View caller) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(caller, "Widok wywo�uj�cy zdarzenie nie zosta� ustawiony!");
	this.caller = caller;
    }

    /**
     * @param caller
     *            Widok, kt�ry wywo�a� zdarzenie.
     * @param selectedElementName
     *            Nazwa elementu, kt�rego dotyczy wydarzenie.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nie zostanie podany widok, kt�ry wywo�a�
     *             zdarzenie lub nie zosta�a podana nazwa elementu wybranego w
     *             zdarzeniu.
     */
    public EventArguments(View caller, String selectedElementName) throws IllegalArgumentException {
	this(caller);

	Validator.throwExceptionWhenTextIsEmpty(selectedElementName,
		"Nazwa wybranego w zdarzeniu elementu nie mo�e by� pusta!");
	this.selectedElementName = selectedElementName;
    }

    /**
     * @param view
     *            Widok.
     * @return Wskazuje czy widok jest tym, kt�ry wywo�a� to zdarzenie.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li por�wywany widok nie zosta� stworzony.
     */
    public boolean isCalledBy(View view) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(caller, "Widok wywo�uj�cy zdarzenie nie zosta� ustawiony!");

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
