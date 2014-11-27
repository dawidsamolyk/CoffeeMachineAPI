package edu.issi.machine.subassembly;


/**
 * @author Dawid
 *
 */
public class DefaultHandler extends Handler {

    @Override
    public void run() {
	super.run();
	this.operation.execute();
    }

}
