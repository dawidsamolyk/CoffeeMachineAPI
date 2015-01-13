package edu.issi.machine;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;

@SuppressWarnings("javadoc")
public class DemoGrinding extends Operation {

    public DemoGrinding(Identity identity) {
	super(identity);
    }

    @Override
    public OperationStatus execute() {
	System.out.println("Mielenie kawy...");

	return OperationStatus.Factory.createValidState();
    }

}
