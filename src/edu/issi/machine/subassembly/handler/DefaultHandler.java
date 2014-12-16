package edu.issi.machine.subassembly.handler;

import edu.issi.machine.operation.OperationState;

/**
 * @author Dawid
 *
 */
public class DefaultHandler extends Handler {

    @Override
    protected synchronized OperationState runOperation() {
	return operation.execute();
    }

}
