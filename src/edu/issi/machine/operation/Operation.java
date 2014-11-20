package edu.issi.machine.operation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.issi.exceptions.ApiException;
import edu.issi.machine.api.API;
import edu.issi.machine.product.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public class Operation {
    private Method apiMethod;
    private Subassembly subassembly = null;
    private Ingredient ingredient = null;

    /**
     * @param apiMethod
     */
    public Operation(Method apiMethod) {
	this.apiMethod = apiMethod;
    }

    /**
     * @param subassembly
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setSubassembly(Subassembly subassembly) {
	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setIngredient(Ingredient ingredient) {
	this.ingredient = ingredient;
	return this;
    }

    /**
     * @return Stan operacji.
     */
    public OperationState execute() {
	if (isRequiredElementsProvided()) {
	    return new OperationState(Status.ERROR, "Nie podano podzespolu lub skladnika dla tej operacji!");
	}

	if (canDoThisOperation(this.subassembly)) {
	    return new OperationState(Status.ERROR, "Podzespol nie moze wykonac tej operacji!");
	}

	return executeApiOperation();
    }

    private boolean canDoThisOperation(Subassembly subassembly) {
	return subassembly.supports(this) == false;
    }

    private boolean isRequiredElementsProvided() {
	return (this.subassembly == null || this.ingredient == null);
    }

    private OperationState executeApiOperation() {
	try {
	    ivokeApiMethod();
	} catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
	    return new OperationState(Status.ERROR, "Nie mozna wykonac operacji (blad API)!");

	} catch (ApiException e) {
	    return new OperationState(e.getStatus(), e.getMessage());
	}

	return new OperationState(Status.OK);
    }

    private void ivokeApiMethod() throws IllegalAccessException, IllegalArgumentException,
	    InvocationTargetException, ApiException {
	this.apiMethod.invoke(API.API, API.EXAMPLE_VALUE);
    }

}
