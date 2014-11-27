package edu.issi.machine.api;

import java.io.PrintStream;

import edu.issi.machine.TestingApi;

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

    public void log(String message) {
	printStream.println(message);
    }

    public void log(Exception e) {
	exceptionsStream.println(e);
    }

}
