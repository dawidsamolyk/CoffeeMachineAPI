package edu.issi.machine.api;

@SuppressWarnings("javadoc")
public class MachineApi {
    public static final MachineApi API = new MachineApi();
    public static final int EXAMPLE_VALUE = 1;

    private int i = 0;

    public static void giveTheCup(Integer quantity) {
	// System.out.println("Podaje " + quantity + " kubków...");
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + i;
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
	if (i != other.i)
	    return false;
	return true;
    }

}
