package edu.issi.machine;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;

public class FakeGrinding extends Operation {

    public FakeGrinding(Identity identity) {
	super(identity);
    }

    @Override
    public OperationState execute() {
	System.out.println("Mielenie kawy...");
	
	return new OperationState.Factory().createValidState();
    }

}
