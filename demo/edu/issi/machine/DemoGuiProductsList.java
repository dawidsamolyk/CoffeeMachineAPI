package edu.issi.machine;

import java.util.List;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;

@SuppressWarnings("javadoc")
public class DemoGuiProductsList extends Operation {
    private List<Product> products;

    public DemoGuiProductsList(Identity identity, List<Product> products) {
	super(identity);
	this.products = products;
    }

    @Override
    public OperationStatus execute() {
	System.out.println("---------------------");
	System.out.println("Lista dostêpnych produktów:");

	for (ObjectWithIdentity each : products) {
	    System.out.print("\t* ");
	    System.out.println(each);
	}

	System.out.println("---------------------");

	return OperationStatus.Factory.createValid();
    }

}
