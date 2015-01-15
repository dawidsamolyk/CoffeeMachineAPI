package edu.issi.machine.subassembly;

import java.util.Arrays;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.Operation;

@SuppressWarnings("javadoc")
public class TestingSubassembly extends Subassembly {

    public TestingSubassembly(Identity id, List<Operation> operations) throws IllegalArgumentException {
	super(id, operations);
    }

    public int getOperationsQuantity() {
	return this.operations.size();
    }
    
    @Override
    public void run() {
	
    }
    
    @Override
    public void stop() {
	
    }

    public static TestingSubassembly getFixtureWith(Operation ... testingOperations) throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	List<Operation> operations = Arrays.asList(testingOperations);
	
	return new TestingSubassembly(IdentityTest.getIdentityFixture(), operations);
    }

}
