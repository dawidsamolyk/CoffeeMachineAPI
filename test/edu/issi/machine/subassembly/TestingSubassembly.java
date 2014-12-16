package edu.issi.machine.subassembly;

import java.util.List;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.subassembly.handler.Handler;

@SuppressWarnings("javadoc")
public class TestingSubassembly extends Subassembly {
   
    public TestingSubassembly(Identity id, List<Operation> operations) throws IllegalArgumentException {
	super(id, operations);
    }

    public int getHandlersQuantity() {
	return this.handlers.size();
    }

    public int getOperationsQuantity() {
	return this.operations.size();
    }

    public boolean isAllOperationsDone() {
	for (Handler each : handlers) {
	    if (!each.isOperationDone()) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public void run() {

    }

}
