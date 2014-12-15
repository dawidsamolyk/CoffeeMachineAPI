package edu.issi.machine;

import java.util.List;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;
import edu.issi.machine.product.Product;

public class FakeGuiProductsList extends Operation {
    private List<Product> products;

    public FakeGuiProductsList(Identity identity, List<Product> products) {
	super(identity);
	this.products = products;
    }

    @Override
    public OperationState execute() {
	System.out.println("---------------------");
	System.out.println("Lista dostêpnych produktów:");

	for (ObjectWithIdentity each : products) {
	    System.out.print("\t* ");
	    System.out.println(each);
	}
	
	System.out.println("---------------------");

	return new OperationState.Factory().createValidState();
    }

}
