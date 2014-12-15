package edu.issi.machine;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;

public class TestingOperation extends Operation {
    private Identity identity;

    public TestingOperation(Identity identity) {
	super(identity);
	this.identity = identity;
    }

    @Override
    public OperationState execute() {
	System.out.println("Operacja na sk³adniku: " + ingredient);
	System.out.println(identity.toString());
	System.out.println("\tW³aœciwoœci sk³adnika: ");
	System.out.println("\t\tIloœæ: " + ingredient.getValueForPropertyWithName("Iloœæ"));
	System.out.println("\t\tTemperatura: " + ingredient.getValueForPropertyWithName("Temperatura"));
	System.out.println("\t\tRozmiar porcji: " + ingredient.getValueForPropertyWithName("Rozmiar porcji"));
	
	return new OperationState.Factory().createValidState();
    }

}
