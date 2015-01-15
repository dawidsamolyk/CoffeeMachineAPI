package edu.issi.machine;

import java.util.Map;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;

@SuppressWarnings("javadoc")
public class DemoOperation extends Operation {
    private Identity identity;

    public DemoOperation(Identity identity) {
	super(identity);
	this.identity = identity;
    }

    @Override
    public OperationStatus execute() {
	System.out.println("Operacja na sk³adniku: " + ingredient);
	System.out.println(identity.toString());
	System.out.println("\tW³aœciwoœci sk³adnika: ");
	
	Map<PropertyIdentity, Double> properties = ingredient.getProperties();
	
	for(PropertyIdentity each : properties.keySet()) {
	    Double value = properties.get(each);
	    System.out.println("\t\t" + each.getName() + " : " + value + each.getUnit());
	}
	
	return OperationStatus.Factory.createValid();
    }

}
