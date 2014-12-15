/**
 * 
 */
package edu.issi.machine.subassembly.handler;

import edu.issi.machine.operation.OperationState;
import edu.issi.machine.operation.Status;

/**
 * @author Dawid
 *
 */
public class Listener extends Handler implements Runnable {
    private OperationState state;
    private long threadSleepTime;

    public Listener(long threadSleepTimeInMiliseconds) {
	this.threadSleepTime = threadSleepTimeInMiliseconds;
    }

    /*
     * (non-Javadoc)
     * @see edu.issi.machine.subassembly.handler.Handler#runOperation()
     */
    @Override
    protected OperationState runOperation() {
	run();

	return state;
    }

    @Override
    public void run() {
	int iterations = 0;

	while (!operation.isDone()) {
	    if (iterations > 1000) {
		break;
	    }

	    state = operation.execute();

	    try {
		Thread.sleep(threadSleepTime);
	    }
	    catch (InterruptedException e) {
		state = new OperationState(Status.ERROR,
			"B��d podczas wykonywania operacji. Dok�adny pow�d: " + e.getMessage());
		break;
	    }

	    iterations++;
	}
    }

}
