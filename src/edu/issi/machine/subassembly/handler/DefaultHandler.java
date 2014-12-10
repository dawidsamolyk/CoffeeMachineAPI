package edu.issi.machine.subassembly.handler;

import edu.issi.machine.operation.OperationState;

/**
 * @author Dawid
 *
 */
public class DefaultHandler extends Handler {
	/**
     * 
     */
	private static final long serialVersionUID = -2630364444549664861L;

	@Override
	protected synchronized OperationState runOperation() {
		return operation.execute();
	}

}
