package edu.issi.machine.subassembly.handler;

import edu.issi.machine.operation.OperationStatus;

/**
 * @author Dawid
 *
 */
public class DefaultHandler extends Handler {

    @Override
    protected synchronized OperationStatus runOperation() {
	return operation.execute();
    }

}
