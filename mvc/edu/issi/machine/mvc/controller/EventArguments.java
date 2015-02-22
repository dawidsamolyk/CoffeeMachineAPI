package edu.issi.machine.mvc.controller;

import edu.issi.machine.Validator;
import edu.issi.machine.mvc.view.View;

/**
 * @author DawidSamolyk
 *         Argumenty wydarzenia.
 */
public class EventArguments {
    private View caller;
    private String selectedElementName;

    /**
     * Konstruktor. Widok, który wywo³a³ wydarzenie, jest wymagany.
     * 
     * @param caller
     *            Widok, który wywo³a³ zdarzenie.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nie zostanie podany widok, który wywo³a³
     *             zdarzenie.
     */
    public EventArguments(View caller) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(caller, "Widok wywo³uj¹cy zdarzenie nie zosta³ ustawiony!");
	this.caller = caller;
    }

    /**
     * Konstruktor. Widok, który wywo³a³ wydarzenie, jest wymagany. Równie¿
     * nazwa wybranego elementu jest wymagana. Jest to dodatkowy argument, wiêc
     * jeœli nie jest konieczny, u¿yj innego konstruktora.
     * 
     * @param caller
     *            Widok, który wywo³a³ zdarzenie.
     * @param selectedElementName
     *            Nazwa elementu, którego dotyczy wydarzenie.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nie zostanie podany widok, który wywo³a³
     *             zdarzenie lub nie zosta³a podana nazwa elementu wybranego w
     *             zdarzeniu.
     */
    public EventArguments(View caller, String selectedElementName) throws IllegalArgumentException {
	this(caller);

	Validator.throwExceptionWhenTextIsEmpty(selectedElementName, "Nazwa wybranego w zdarzeniu elementu nie mo¿e byæ pusta!");
	this.selectedElementName = selectedElementName;
    }

    /**
     * Podaje informacje na temat tego czy podany widok wywo³a³ zdarzenie, które
     * niesie ten argument.
     * 
     * @param view
     *            Widok.
     * @return Wskazuje czy widok jest tym, który wywo³a³ to zdarzenie.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli porówywany widok nie zosta³ stworzony.
     */
    public boolean isCalledBy(View view) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(caller, "Widok wywo³uj¹cy zdarzenie nie zosta³ ustawiony!");

	return view.equals(caller);
    }

    /**
     * Pobranie nazwy elementu.
     * 
     * @return Nazwa elementu, którego dotyczy zdarzenie.
     */
    public String getSelectedElementName() {
	return selectedElementName;
    }

    /**
     * Informuje czy podano dodatkowy argument.
     * 
     * @return Wskazuje czy posiada ustawion¹ nazwê elementu, którego dotyczy
     *         zdarzenie.
     */
    public boolean hasSelectedElementName() {
	return selectedElementName != null;
    }
}
