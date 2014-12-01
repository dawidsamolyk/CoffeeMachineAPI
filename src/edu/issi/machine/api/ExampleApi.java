package edu.issi.machine.api;

import java.io.PrintStream;

import edu.issi.machine.TestingApi;
import edu.issi.machine.product.ingredient.IngredientUnit;

@SuppressWarnings("javadoc")
public class ExampleApi {
    public static final ExampleApi INSTANCE = new ExampleApi();

    private PrintStream printStream = System.out;
    private PrintStream exceptionsStream = System.err;

    public void prepareCup() {
	printStream.print("Przygotowuje kubek...");
    }
    
    public void giveCup() {
	printStream.print("Podaje kubek...");
    }

    public void heat(Integer quantity, IngredientUnit unit) {
	printStream.print("Podgrzewa przy temperaturze " + quantity + unit.toString() + "...");
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
