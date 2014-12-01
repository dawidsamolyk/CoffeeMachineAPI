package edu.issi.machine;

import edu.issi.machine.api.ExampleApi;

@SuppressWarnings("javadoc")
public class TestingApi extends ExampleApi {
    public static final ExampleApi INSTANCE = new TestingApi();
    
    public void giveTheCup(Integer quantity) {
    }

    public void log(String message) {
    }

    public void log(Exception e) {
    }
}
