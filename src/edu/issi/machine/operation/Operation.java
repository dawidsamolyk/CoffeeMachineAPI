package edu.issi.machine.operation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.issi.exceptions.ApiException;
import edu.issi.machine.api.ExampleApi;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public class Operation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8742139834110667380L;
    
    private Method apiMethod;
    private Subassembly subassembly = null;
    private Ingredient ingredient = null;

    /**
     * @param apiMethod
     *            Metoda (funkcja) API maszyny.
     */
    public Operation(Method apiMethod) {
	this.apiMethod = apiMethod;
    }

    /**
     * @param subassembly
     *            Podzespó³, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setSubassembly(Subassembly subassembly) {
	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     *            Sk³adnik, na którym ma zostaæ wykonana operacja.
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
	if (!isRequiredElementsProvided()) {
	    return new OperationState(Status.ERROR, "Nie podano podzespolu lub skladnika dla tej operacji!");
	}

	if (!canDoThisOperation(subassembly)) {
	    return new OperationState(Status.ERROR, "Podzespol nie moze wykonac tej operacji!");
	}

	return executeApiOperation();
    }

    private boolean canDoThisOperation(Subassembly subassembly) {
	return subassembly.supports(this);
    }

    private boolean isRequiredElementsProvided() {
	return (subassembly != null && ingredient != null);
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
	apiMethod.invoke(ExampleApi.API, 1);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apiMethod == null) ? 0 : apiMethod.hashCode());
	result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
	result = prime * result + ((subassembly == null) ? 0 : subassembly.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Operation other = (Operation) obj;
	if (apiMethod == null) {
	    if (other.apiMethod != null)
		return false;
	} else if (!apiMethod.equals(other.apiMethod))
	    return false;
	if (ingredient == null) {
	    if (other.ingredient != null)
		return false;
	} else if (!ingredient.equals(other.ingredient))
	    return false;
	if (subassembly == null) {
	    if (other.subassembly != null)
		return false;
	} else if (!subassembly.equals(other.subassembly))
	    return false;
	return true;
    }

}
