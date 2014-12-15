/**
 * 
 */
package edu.issi.machine;

import java.util.Iterator;
import java.util.List;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 *
 */
public class DemoUserInterfaceSubassembly extends Subassembly implements Runnable {
    public boolean working = true;

    /**
     * @param id
     * @param operations
     * @param products
     * @throws IllegalArgumentException
     */
    public DemoUserInterfaceSubassembly(Identity id, List<Operation> operations)
	    throws IllegalArgumentException {
	super(id, operations);
    }

    @Override
    public void run() {
	while (working) {
	    for (Operation each : operations) {
		OperationState state = each.execute();
		
		if(state.getStatus().requiresAttention()) {
		    System.err.println(state.getDescription());
		}
		else if(each instanceof DemoGuiProductChooser) {
		    Product product = ((DemoGuiProductChooser) each).getSelected();
		    
		    Iterator<Ingredient> iterator = product.iterator();
		    
		    while(iterator.hasNext()) {
			iterator.next().doOperations();
		    }
		}
	    }
	}
    }
}
