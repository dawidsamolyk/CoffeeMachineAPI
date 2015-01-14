package edu.issi.machine.subassembly;

import java.util.Arrays;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.IdentityTest;
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

    public static TestingSubassembly getFixtureWith(Operation ... testingOperations) throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Identity id = IdentityTest.getIdentityFixture();
	List<Operation> operations = Arrays.asList(testingOperations);
	
	return new TestingSubassembly(id, operations);
    }

}
