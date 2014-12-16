package edu.issi.machine;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;

@SuppressWarnings("javadoc")
public class DemoGrinding extends Operation {

    public DemoGrinding(Identity identity) {
	super(identity);
    }

    @Override
    public OperationState execute() {
	System.out.println("Mielenie kawy...");

	return new OperationState.Factory().createValidState();
    }

}
