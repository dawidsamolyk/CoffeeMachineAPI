package edu.issi.machine.api;

import java.io.PrintStream;
import java.lang.reflect.Method;

import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class Api {
    private final PrintStream output = System.out;
    private final PrintStream exteptionsOutput = System.err;

    public void execute(Subassembly subassembly, Ingredient ingredient) {
	output.print(subassembly.toString() + " przygotowuje " + ingredient.toString());
    }

    public void log(String message) {
	output.println(message);
    }

    public void logError(Exception e) {
	exteptionsOutput.println(e);
    }

    public boolean contains(Method method) {
	for (Method each : getClass().getDeclaredMethods()) {
	    if (each.equals(method)) {
		return true;
	    }
	}
	return false;
    }
}
