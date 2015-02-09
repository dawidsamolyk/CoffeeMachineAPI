package edu.issi.machine.operation.fakes;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;

@SuppressWarnings("javadoc")
public class FakeOperation extends Operation {

    public FakeOperation() throws IllegalArgumentException {
	super(IdentityTest.getIdentityFixture());
    }

    @Override
    public OperationStatus execute() {
	return OperationStatus.Factory.createValid();
    }

}
