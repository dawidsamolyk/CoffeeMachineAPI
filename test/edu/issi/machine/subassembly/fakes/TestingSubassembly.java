package edu.issi.machine.subassembly.fakes;

import java.util.Arrays;
import java.util.List;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class TestingSubassembly extends Subassembly {
    private boolean running = false;

    public TestingSubassembly(Identity id, List<Operation> operations) throws IllegalArgumentException {
	super(id, operations);
    }

    public int getOperationsQuantity() {
	return this.operations.size();
    }

    @Override
    public void run() {
	running = true;
    }

    @Override
    public void stop() {
	running = false;
    }

    public boolean isRunning() {
	return running;
    }

    public static TestingSubassembly getFixtureWith(Operation... testingOperations) throws IllegalArgumentException {
	List<Operation> operations = Arrays.asList(testingOperations);

	return new TestingSubassembly(IdentityTest.getIdentityFixture(), operations);
    }

}
