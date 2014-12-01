package edu.issi.machine.api;

import java.io.PrintStream;
import java.lang.reflect.Method;

import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class Api {
    private final PrintStream output = System.out;
    private final PrintStream exteptionsOutput = System.err;

    public void prepareCup() {
	output.print("Przygotowuje kubek...");
    }

    public void giveCup() {
	output.print("Podaje kubek...");
    }

    public void heat(Ingredient ingredient) {
	output.print("Podgrzewa...");
    }

    public void giveIngredient(Integer quantity, Unit unit) {
	output.print("Podaje sk³adnik...");
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
