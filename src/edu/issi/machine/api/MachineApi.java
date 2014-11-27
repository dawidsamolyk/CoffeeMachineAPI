package edu.issi.machine.api;

import java.io.PrintStream;

@SuppressWarnings("javadoc")
public class MachineApi {
    private PrintStream printStream = System.out;
    private PrintStream exceptionsStream = System.err;
    public static final MachineApi API = new MachineApi();
    public static final int EXAMPLE_VALUE = 1;

    public void giveTheCup(Integer quantity) {
	printStream.println("Podaje " + quantity + " kubków...");
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((exceptionsStream == null) ? 0 : exceptionsStream.hashCode());
	result = prime * result + ((printStream == null) ? 0 : printStream.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MachineApi other = (MachineApi) obj;
	if (exceptionsStream == null) {
	    if (other.exceptionsStream != null)
		return false;
	} else if (!exceptionsStream.equals(other.exceptionsStream))
	    return false;
	if (printStream == null) {
	    if (other.printStream != null)
		return false;
	} else if (!printStream.equals(other.printStream))
	    return false;
	return true;
    }

    public void log(String message) {
	printStream.println(message);
    }

    public void log(Exception e) {
	exceptionsStream.println(e);
    }

}
