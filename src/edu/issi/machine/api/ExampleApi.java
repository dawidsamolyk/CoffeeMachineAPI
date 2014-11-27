package edu.issi.machine.api;

import java.io.PrintStream;

import edu.issi.machine.TestingApi;
import edu.issi.machine.product.ingredient.IngredientUnit;

@SuppressWarnings("javadoc")
public class ExampleApi {
    public static final ExampleApi API = new ExampleApi();
    public static final ExampleApi TESTING_API = new TestingApi();

    private PrintStream printStream = System.out;
    private PrintStream exceptionsStream = System.err;

    public void giveTheCup(Integer quantity) {
	printStream.print("Podaje ");
	printStream.print(quantity);
	printStream.println(" kubków...");
    }

    public void heat(Integer quantity, IngredientUnit unit) {
	printStream.print("Podgrzewam przy temperaturze " + quantity + unit.toString() + "...");
    }

    public void giveIngredient(Integer quantity, IngredientUnit unit) {
	printStream.print("Podaje ");
	printStream.print(quantity);
	printStream.println(unit.toString() + " sk³adnika...");
    }

    public void log(String message) {
	printStream.println(message);
    }

    public void log(Exception e) {
	exceptionsStream.println(e);
    }

}
