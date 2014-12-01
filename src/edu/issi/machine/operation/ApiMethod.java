package edu.issi.machine.operation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.issi.machine.Validator;
import edu.issi.machine.api.Api;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 *
 */
public class ApiMethod {
    private Api api;
    private Method method;

    /**
     * @param api
     *            API.
     * @param method
     *            Funkcja do wykonania.
     */
    public ApiMethod(Api api, Method method) {
	Validator.throwExceptionWhenObjectIsNotCreated(api,
		"Nie mo�na zadeklarowa� funkcji API bez wskazania API!");

	Validator.throwExceptionWhenObjectIsNotCreated(method,
		"Nie mo�na zadeklarowa� funkcji API bez wskazania �r�d�owej funkcji!");

	if (!api.contains(method)) {
	    throw new IllegalArgumentException("Wybrane API nie zawiera podanej funkcji!");
	}
	this.method = method;
    }

    /**
     * 
     * @param subassembly
     *            Podzesp�, na kt�rym zostanie wykonana funkcja.
     * @param ingredient
     *            Sk�adnik na rzecz kt�rego zostanie wywo�ana funkcja.
     * @return Stan po wykonaniu funkcji.
     */
    public OperationState execute(Subassembly subassembly, Ingredient ingredient) {
	try {
	    method.invoke(api, subassembly, ingredient);
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	    return new OperationState(Status.ERROR, e.getMessage());
	}

	return new OperationState(Status.OK);
    }
}
